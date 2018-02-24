package com.acewill.dbsync.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;

import com.acewill.dbsync.common.Constant;
import com.acewill.dbsync.common.Global;
import com.acewill.dbsync.common.SqlUtil;
import com.acewill.dbsync.dao.SyncMapper;
import com.acewill.dbsync.entity.BtnPage;
import com.acewill.dbsync.entity.Button;
import com.acewill.dbsync.entity.Card;
import com.acewill.dbsync.entity.CardDetail;
import com.acewill.dbsync.entity.CodeContent;
import com.acewill.dbsync.entity.CodeDefintion;
import com.acewill.dbsync.entity.SqlColumn;
import com.acewill.dbsync.entity.SqlColumnSchema;
import com.acewill.dbsync.entity.SqlIndex;
import com.acewill.dbsync.entity.SqlObject;
import com.acewill.dbsync.entity.SyncSchema;
import com.acewill.dbsync.entity.SysMenu;
import com.acewill.dbsync.entity.SysModule;
import com.acewill.dbsync.entity.Table;
import com.acewill.dbsync.entity.TableColumn;
import com.acewill.dbsync.service.SyncService;
import com.alibaba.druid.util.StringUtils;

@Service("syncService")
public class SyncServiceImpl implements SyncService {
    
    @Autowired
    private SyncMapper syncMapper;
    
    private String end = Constant.SIGN_SQLEND + Constant.SIGN_NEWLINE;
    
    private String pie = "`";
    
    private String definerReg = "DEFINER=`.*?`@`.*?`";
    
    private Set<String> lostTableList = new HashSet<String>();
    
    private Set<String> removeTableList = new HashSet<String>();
    
    @Override
    public String generateSql() {
        String masterSchema = Global.getConfig("ds.master.schema");
        String slaveSchema = Global.getConfig("ds.slave.schema");
        return generateSql(masterSchema, slaveSchema);
    }
    
    
    @Override
    public String generateSql(String masterSchema, String slaveSchema){
        if(StringUtils.isEmpty(masterSchema)){
            masterSchema = Global.getConfig("ds.master.schema");
        }
        if(StringUtils.isEmpty(slaveSchema)){
            slaveSchema = Global.getConfig("ds.slave.schema");
        }
        String result = "";
        SyncSchema syncSchema = new SyncSchema(masterSchema, slaveSchema);
        // 查缺失的表
        result += "/**------------------------创建缺失表------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllLostTableSQL(syncSchema);
        // 查删除的表
        result += "/**------------------------删除多余表------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllRemoveTableSQL(syncSchema);
        // 重新创建所有 存储过程、函数、触发器
        // 存储过程
        result += "/**------------------------重新创建存储过程------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllProcedureSQL(masterSchema);
        // 函数
        result += "/**------------------------重新创建函数------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllFunctionSQL(masterSchema);
        // 触发器
        result += "/**------------------------重新创建触发器------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllTriggerSQL(masterSchema);
        
        // 查修改的列
        result += "/**------------------------修改的列------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllChangedColumnSQL(syncSchema);
        // 查缺失的列
        result += "/**------------------------添加缺失的列------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllLostColumnSQL(syncSchema);
        // 查删除的列，带数据条数
        result += "/**------------------------删除多余的列------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllRemoveColumnSQL(syncSchema);
        // 查缺失的索引
        result += "/**------------------------添加缺失的索引------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllLostIndexSQL(syncSchema);
        // 查删除的索引
        result += "/**------------------------删除多余索引------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllRemoveIndexSQL(syncSchema);
        // 初始化信息sql：编码，工资套
        result += "/**------------------------初始化 编码 权限按钮 和 工资项------------------------**/" + Constant.SIGN_NEWLINE;
        result += selectAllInitSQL(syncSchema);
        
        return result;
    }
    
    @Override
    public List<Table> getAllTables() throws IOException{
        String tableSchema = "acewill_new";
        List<Map<String, String>> tableList = syncMapper.selectAllTable(tableSchema);
        List<Table> result = new ArrayList<Table>();
        
        for(Map<String, String> tableMap : tableList){
            String tableName = tableMap.get("table_name");
            String tableComment = tableMap.get("table_comment");
            SqlObject sqlObject = new SqlObject(tableSchema, Constant.SQLOBJ_TABLE, tableName);
            String createSQL = syncMapper.selectCreateSqlObj(sqlObject).get(Constant.SQLOBJ_TABLE_CH) + end;
            Table table = new Table();
            table.setTableName(tableName);
            table.setTableComment(tableComment);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(createSQL.getBytes())));
            String str = "";
            int lineNum = 0;
            int endLineNum = 0;
            List<TableColumn> columns = new ArrayList<TableColumn>();
            while((str = reader.readLine())!=null){
                if((str.trim().startsWith("PRIMARY KEY") || str.trim().startsWith(")") || str.trim().startsWith("KEY")) && endLineNum == 0){
                    endLineNum = lineNum;
                }
                lineNum++;
                if(lineNum>=2 && endLineNum==0){
                    System.out.println(str);
                    String columnName = str.split("`")[1];
                    String columnType = str.split(" ")[3];
                    TableColumn column = new TableColumn();
                    column.setColumnName(columnName);
                    column.setColumnType(columnType);
                    
                    if(str.contains("COMMENT '")){
                        String comment = str.substring(str.indexOf("COMMENT '")+9, str.lastIndexOf("'"));
                        String defaultStr = str.substring(str.indexOf(columnType)+columnType.length(), str.indexOf(" COMMENT"));
                        column.setComment(comment);
                        column.setDefaultStr(defaultStr);
                    }else{
                        String defaultStr = str.substring(str.indexOf(columnType)+columnType.length());
                        column.setDefaultStr(defaultStr);
                    }
                    System.out.println(column.getComment());
                    columns.add(column);
                }
                if(str.trim().startsWith("PRIMARY KEY")){
                    table.setPrimaryKey(str);
                }
                if(str.trim().startsWith("KEY")){
                    table.setIndex(str);
                }
                if(str.trim().startsWith(")")){
                    table.setOthers(str);
                }
            }
            table.setColumns(columns);
            Map<String, String> params = new HashMap<String ,String>();
            params.put("tableSchema", tableSchema);
            params.put("tableName", tableName);
            List<String> triggerNameList = syncMapper.selectTableTrigger(params);
            if(triggerNameList!=null && triggerNameList.size()>0){
                String triggerSql = "";
                for(String triggerName : triggerNameList){
                    SqlObject sqlObjectTrigger = new SqlObject(tableSchema, Constant.SQLOBJ_TRIGGER, triggerName);
                    String createSQLTrigger = syncMapper.selectCreateSqlObj(sqlObjectTrigger).get(Constant.SQLOBJ_TRIGGER_CH) + end;
                    createSQLTrigger = createSQLTrigger.replaceAll(definerReg, "");
                    triggerSql+= createSQLTrigger+Constant.SIGN_NEWLINE;
                }
                table.setTrigger(triggerSql);
            }
            result.add(table);
        }
        return result;
    }
    
    
    /**
     * 初始化信息sql：编码，工资套
     * 
     * @author Liucl
     * @datetime 2016年9月9日 下午4:29:10
     */
    private String selectAllInitSQL(SyncSchema syncSchema) {
        String result = "";
        // 查询主库有，从库没有的编码，生成insert语句
        result += codecontent(syncSchema);
        result += sysmodule(syncSchema);// module 关联修改 btnpage/sysmenu/companymodule
        result += sysmenu(syncSchema);// menu 关联修改 rolemenu
        result += butpage(syncSchema);// btnpage 关联修改button
        result += button(syncSchema);// button 关联修改 rolepagebtn
        result += card(syncSchema);// card
        result += cardDetail(syncSchema);
        // 初始化文件读取
        result += readFile();
        return result;
    }
    
    private String str(String columnValue) {
        if (StringUtils.isEmpty(columnValue)) {
            return null;
        } else {
            return "'" + columnValue + "'";
        }
    }
    
    private String str(Date columnValue) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (columnValue == null) {
            return null;
        } else {
            return "'" + dateFormat.format(columnValue) + "'";
        }
    }
    
    /**
     * 初始化编码表
     * 
     * @author Liucl
     * @datetime 2016年9月14日 下午6:46:58
     */
    private String codecontent(SyncSchema syncSchema) {
        String result = "";
        List<CodeDefintion> defintionList = syncMapper.selectUnExistCodeDefinaList(syncSchema);
        List<CodeContent> contentList = syncMapper.selectUnExistCodeContentList(syncSchema);
        for (CodeDefintion def : defintionList) {
            result += "INSERT INTO codedefintion(defintionCode, difintionName, parentID, viewType, createTime, des, valid) VALUES(" 
                + str(def.getDefintionCode()) + ", " + str(def.getDifintionName()) + ", " + def.getParentID() + ", " + str(def.getViewType())
                + ", " + str(def.getCreateTime()) + ", " + str(def.getDes()) + ", " + def.getValid() + " )" + end;
        }
        for (CodeContent con : contentList) {
            result += "INSERT INTO codecontent( codeName, code, difintionID, orderNum, createTime, des, valid, flag) VALUES(" + str(con.getCodeName())
                + ", " + str(con.getCode()) + ", (SELECT ID FROM codedefintion WHERE defintionCode='"+con.getDefintionCode()+"'), " + con.getOrderNum() + ", " + str(con.getCreateTime()) + ", "
                + str(con.getDes()) + ", " + con.getValid() +  ", " +con.getFlag() + ")" + end;
        }
        return result;
    }
    
    /**
     * 初始化系统模块 关联修改 btnpage/sysmenu/companymodule
     * 
     * @author Liucl
     * @datetime 2016年9月14日 下午7:44:46
     */
    private String sysmodule(SyncSchema syncSchema) {
        String result = "";
        List<SysModule> mList = syncMapper.selectAllSysModule(syncSchema.getMasterSchema());
        List<SysModule> sList = syncMapper.selectAllSysModule(syncSchema.getSlaveSchema());
        Map<String, SysModule> sMap = new HashMap<String, SysModule>();
        for (SysModule s : sList) {
            sMap.put(s.getModuleName(), s);
        }
        for (SysModule m : mList) {
            if (sMap.get(m.getModuleName()) == null) {
                result += "INSERT INTO sysmodule(moduleName, createTime, des, valid) VALUES(" + str(m.getModuleName()) + ", " + str(m.getCreateTime())
                    + ", " + str(m.getDes()) + ", " + m.getValid() + ")" + end;
            } else {
//                SysModule s = sMap.get(m.getModuleName());
//                if (!s.getID().equals(m.getID())) {
//                    result += "UPDATE sysmodule SET ID = " + m.getID() + " WHERE moduleName = " + str(m.getModuleName()) + end;
//                    result += "UPDATE btnpage SET moduleID = " + m.getID() + " WHERE moduleID = " + s.getID() + end;
//                    result += "UPDATE sysmenu SET moduleID = " + m.getID() + " WHERE moduleID = " + s.getID() + end;
//                    result += "UPDATE companymodule SET moduleID = " + m.getID() + " WHERE moduleID = " + s.getID() + end;
//                }
            }
        }
        return result;
    }
    
    /**
     * 初始化菜单 关联修改 rolemenu
     * 
     * @author Liucl
     * @datetime 2016年9月14日 下午7:55:04
     */
    private String sysmenu(SyncSchema syncSchema) {
        String result = "";
        List<SysMenu> mList = syncMapper.selectAllSysMenu(syncSchema.getMasterSchema());
        List<SysMenu> sList = syncMapper.selectAllSysMenu(syncSchema.getSlaveSchema());
        Map<String, SysMenu> sMap = new HashMap<String, SysMenu>();
        for (SysMenu s : sList) {
            sMap.put(s.getMenuName(), s);
        }
        for (SysMenu m : mList) {
            if (sMap.get(m.getMenuName()) == null) {
                result += "INSERT INTO sysmenu(moduleID, menuName, parentID, imagUrl, orderNum, url, isLeft, createTime, des, valid) VALUES("
                    + "(SELECT ID FROM sysmodule WHERE moduleName='"+m.getModuleName()+"'), " + str(m.getMenuName()) + ", " + m.getParentID() + ", " + str(m.getImagUrl()) + ", " + m.getOrderNum()
                    + ", " + str(m.getUrl()) + ", " + m.getIsLeft() + ", " + str(m.getCreateTime()) + ", " + str(m.getDes()) + ", " + m.getValid()
                    + ")" + end;
            } else {
                SysMenu s = sMap.get(m.getMenuName());
                if (!StringUtils.equals(m.getImagUrl(), s.getImagUrl()) || !StringUtils.equals(m.getUrl(), s.getUrl())
                    || m.getValid() != s.getValid()) {
                    result += "UPDATE sysmenu SET imagUrl = " + str(m.getImagUrl()) + ", url = " + str(m.getUrl()) + ", valid = " + m.getValid()
                        + " WHERE menuName=" + str(m.getMenuName()) + end;
                }
//                if (!m.getID().equals(s.getID())) {
//                    result += "UPDATE sysmenu SET ID = " + m.getID() + " WHERE ID = " + s.getID() + end;
//                    result += "UPDATE rolemenu SET menuID = " + m.getID() + " WHERE menuID = " + s.getID() + end;
//                }
            }
        }
        return result;
    }
    
    /**
     * 初始化按钮页面 关联修改button
     * 
     * @author Liucl
     * @datetime 2016年9月14日 下午7:18:44
     */
    private String butpage(SyncSchema syncSchema) {
        String result = "";
        List<BtnPage> mList = syncMapper.selectAllBtnPage(syncSchema.getMasterSchema());
        if (!lostTableList.contains("btnpage")) {
            List<BtnPage> sList = syncMapper.selectAllBtnPage(syncSchema.getSlaveSchema());
            Map<String, BtnPage> sMap = new HashMap<String, BtnPage>();
            for (BtnPage s : sList) {
                sMap.put(s.getPageName(), s);
            }
            for (BtnPage m : mList) {
                if (sMap.get(m.getPageName()) == null) {
                    result += "INSERT INTO btnpage(moduleID, pageName, pageCode, createTime, des, valid) VALUES("
                        + "(SELECT ID FROM sysmodule WHERE moduleName='"+m.getModuleName()+"'), "
                        + str(m.getPageName()) + ", " + str(m.getPageCode()) + ", " + str(m.getCreateTime()) + ", " + str(m.getDes()) + ", "
                        + m.getValid() + ")" + end;
                } else {
//                    BtnPage s = sMap.get(m.getPageName());
//                    if (!m.getID().equals(s.getID())) {
//                        result += "UPDATE btnpage SET ID = " + m.getID() + " WHERE ID = " + s.getID() + end;
//                        result += "UPDATE button SET btnPageID = " + m.getID() + " WHERE btnPageID = " + s.getID() + end;
//                    }
                }
            }
        } else {
            for (BtnPage m : mList) {
                result += "INSERT INTO btnpage(moduleID, pageName, pageCode, createTime, des, valid) VALUES("
                        + "(SELECT ID FROM sysmodule WHERE moduleName='"+m.getModuleName()+"'), "
                    + str(m.getPageName()) + ", " + str(m.getPageCode()) + ", " + str(m.getCreateTime()) + ", " + str(m.getDes()) + ", "
                    + m.getValid() + ")" + end;
            }
        }
        return result;
    }
    
    /**
     * 初始化按钮 关联修改 rolepagebtn
     * 
     * @author Liucl
     * @datetime 2016年9月14日 下午6:47:40
     */
    private String button(SyncSchema syncSchema) {
        String result = "";
        List<Button> mButtonList = syncMapper.selectAllButton(syncSchema.getMasterSchema());
        List<Button> sButtonList = syncMapper.selectAllButton(syncSchema.getSlaveSchema());
        Map<String, Button> sBtnMap = new HashMap<String, Button>();
        for (Button btn : sButtonList) {
            sBtnMap.put(btn.getBtnCode(), btn);
        }
        for (Button m : mButtonList) {
            Button s = sBtnMap.get(m.getBtnCode());
            if (s == null) {
                result += "INSERT INTO button(btnName, btnCode, btnPageID, createTime, des, valid) VALUES(" + str(m.getBtnName()) + ", "
                    + str(m.getBtnCode()) + ", (SELECT ID FROM btnpage WHERE pageName='"+m.getPageName()+"'), " + str(m.getCreateTime()) + ", " + str(m.getDes()) + ", " + m.getValid()
                    + ")" + end;
            } else {
                if (!StringUtils.equals(s.getBtnName(), m.getBtnName())) {
                    result += "UPDATE button SET btnName = " + str(m.getBtnName()) + " WHERE btnCode=" + str(m.getBtnCode()) + end;
                }
//                if (!m.getID().equals(s.getID())) {
//                    result += "UPDATE button SET ID = " + m.getID() + " WHERE ID = " + s.getID() + end;
//                    result += "UPDATE rolepagebtn SET btnID = " + m.getID() + " WHERE btnID = " + s.getID() + end;
//                }
            }
        }
        return result;
    }
    /**
     * 初始化card
     * @author Liucl
     * @datetime 2016年11月15日 下午5:59:24
     */
    private String card(SyncSchema syncSchema) {
        String result = "";
        List<Card> mCardList = syncMapper.selectAllCard(syncSchema.getMasterSchema());
        List<Card> sCardList = syncMapper.selectAllCard(syncSchema.getSlaveSchema());
        Map<String, Card> sCardMap = new HashMap<String, Card>();
        for (Card card : sCardList) {
            sCardMap.put(card.getName(), card);
        }
        for (Card m : mCardList) {
            Card s = sCardMap.get(m.getName());
            if (s == null) {
                result += "INSERT INTO card(name, type, alias, info, url, createTime, des, valid) VALUES(" + str(m.getName()) + ", "
                    + str(m.getType()) + ", "+ str(m.getAlias()) +", " + str(m.getInfo()) + ", "+ str(m.getUrl()) + ", "
                    + str(m.getCreateTime()) + ", " + str(m.getDes()) + ", " + m.getValid()
                    + ")" + end;
            } else {
                if (!StringUtils.equals(s.getName(), m.getName())) {
                    result += "UPDATE card SET type = " + str(m.getType()) + ", alias = "+ str(m.getAlias())+
                        ", info = "+ str(m.getInfo()) +", url = "+ str(m.getUrl()) +" WHERE name=" + str(m.getName()) + end;
                }
            }
        }
        return result;
    }
    /**
     * 初始化 card_detail
     * @author Liucl
     * @datetime 2016年11月15日 下午5:59:43
     */
    private String cardDetail(SyncSchema syncSchema) {
        String result = "";
        List<CardDetail> mCDList = syncMapper.selectAllCardDetail(syncSchema.getMasterSchema());
        List<CardDetail> sCDList = syncMapper.selectAllCardDetail(syncSchema.getSlaveSchema());
        Map<String, CardDetail> sCDMap = new HashMap<String, CardDetail>();
        for (CardDetail cd : sCDList) {
            sCDMap.put(cd.getName(), cd);
        }
        for (CardDetail m : mCDList) {
            CardDetail s = sCDMap.get(m.getName());
            if (s == null) {
                result += "INSERT INTO card_detail(name, alias, info, ctrl, cardID, createTime, des, valid) VALUES(" 
                    + str(m.getName()) + ", "+ str(m.getAlias()) + ", "+ str(m.getInfo()) +", "+ str(m.getCtrl()) 
                    + ", (SELECT ID FROM card WHERE name='"+m.getCardName()+"'), " 
                    + str(m.getCreateTime()) + ", " + str(m.getDes()) + ", " + m.getValid()
                    + ")" + end;
            } else {
                if (!StringUtils.equals(s.getName(), m.getName())) {
                    result += "UPDATE card_detail SET alias = " + str(m.getAlias()) 
                            + ", info = "+ str(m.getInfo()) 
                            + ", ctrl = "+ str(m.getCtrl()) 
                            + " WHERE name=" + str(m.getName()) + end;
                }
            }
        }
        return result;
    }
    
    /**
     * 读初始化文件
     * 
     * @author Liucl
     * @datetime 2016年9月14日 下午7:07:14
     */
    private String readFile() {
        String result = "";
        try {
            ;
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DefaultResourceLoader().getResource("init.sql").getInputStream(), "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = reader.readLine()) != null) {
                result += lineTxt + Constant.SIGN_NEWLINE;
            }
            reader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 查缺失的表的sql创建语句
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午7:41:25
     */
    private String selectAllLostTableSQL(SyncSchema syncSchema) {
        String result = "";
        List<String> unExistTableNameList = syncMapper.selectUnExistTableNameList(syncSchema);
        for (String tableName : unExistTableNameList) {
            // 生成缺失表的 建表语句
            SqlObject sqlObject = new SqlObject(syncSchema.getMasterSchema(), Constant.SQLOBJ_TABLE, tableName);
            String dropSQL = "DROP " + Constant.SQLOBJ_TABLE + " IF EXISTS " + tableName + end;
            String createSQL = syncMapper.selectCreateSqlObj(sqlObject).get(Constant.SQLOBJ_TABLE_CH) + end;
            result += dropSQL;
            result += createSQL;
            lostTableList.add(tableName);
        }
        return result;
    }
    
    private String selectAllRemoveTableSQL(SyncSchema syncSchema) {
        String result = "";
        syncSchema = new SyncSchema(syncSchema.getSlaveSchema(), syncSchema.getMasterSchema());
        List<String> unExistTableNameList = syncMapper.selectUnExistTableNameList(syncSchema);
        for (String tableName : unExistTableNameList) {
            // 生成缺失表的 建表语句
            String dropSQL = "DROP " + Constant.SQLOBJ_TABLE + " IF EXISTS " + tableName + end;
            result += dropSQL;
            removeTableList.add(tableName);
        }
        return result;
    }
    
    /**
     * 查所有触发器的sql创建语句
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午7:43:20
     */
    public String selectAllTriggerSQL(String schema) {
        String result = "";
        // 触发器
        List<String> triggerNameList = syncMapper.selectAllTrigger(schema);
        for (String triggerName : triggerNameList) {
            SqlObject sqlObject = new SqlObject(schema, Constant.SQLOBJ_TRIGGER, triggerName);
            String dropSQL = "DROP " + Constant.SQLOBJ_TRIGGER + " IF EXISTS " + triggerName + end;
            String createSQL = syncMapper.selectCreateSqlObj(sqlObject).get(Constant.SQLOBJ_TRIGGER_CH) + end;
            createSQL = createSQL.replaceAll(definerReg, "");
            result += dropSQL;
            result += createSQL;
        }
        return result;
    }
    
    /**
     * 查所有函数的sql创建语句
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午7:43:20
     */
    public String selectAllFunctionSQL(String schema) {
        String result = "";
        // 函数
        List<String> functionNameList = syncMapper.selectAllFunction(schema);
        for (String functionName : functionNameList) {
            if (!functionName.startsWith("_")) {
                SqlObject sqlObject = new SqlObject(schema, Constant.SQLOBJ_FUNCTION, functionName);
                String dropSQL = "DROP " + Constant.SQLOBJ_FUNCTION + " IF EXISTS " + functionName + end;
                String createSQL = syncMapper.selectCreateSqlObj(sqlObject).get(Constant.SQLOBJ_FUNCTION_CH) + end;
                createSQL = createSQL.replaceAll(definerReg, "");
                result += Constant.SIGN_NEWLINE;
                result += dropSQL;
                result += createSQL;
            }
        }
        return result;
    }
    
    /**
     * 查所有存储过程的sql创建语句
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午7:43:20
     */
    public String selectAllProcedureSQL(String schema) {
        String result = "";
        // 存储过程
        List<String> procedureNameList = syncMapper.selectAllProcedure(schema);
        for (String procedureName : procedureNameList) {
            SqlObject sqlObject = new SqlObject(schema, Constant.SQLOBJ_PROCEDURE, procedureName);
            String dropSQL = "DROP " + Constant.SQLOBJ_PROCEDURE + " IF EXISTS " + procedureName + end;
            String createSQL = syncMapper.selectCreateSqlObj(sqlObject).get(Constant.SQLOBJ_PROCEDURE_CH) + end;
            createSQL = createSQL.replaceAll(definerReg, "");
            result += dropSQL;
            result += createSQL;
        }
        return result;
    }
    
    /**
     * 查询所有改变的列
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午8:10:37
     */
    public String selectAllChangedColumnSQL(SyncSchema syncSchema) {
        String result = "";
        List<SqlColumnSchema> allColumnList = syncMapper.selectChangedColumns(syncSchema);
        for (SqlColumnSchema columnSchema : allColumnList) {
            SqlColumn masterCol = columnSchema.getMaster();
            SqlColumn slaveCol = columnSchema.getSlave();
            if (!SqlUtil.filterTable(masterCol.getTableName())) {
                if (!StringUtils.equals(masterCol.getColumnType(), slaveCol.getColumnType())
                    || !StringUtils.equals(masterCol.getIsNullable(), slaveCol.getIsNullable())
                    || !StringUtils.equals(masterCol.getColumnDefault(), slaveCol.getColumnDefault())
                    || !StringUtils.equals(masterCol.getColumnComment(), slaveCol.getColumnComment())
                    || !StringUtils.equals(masterCol.getExtra(), slaveCol.getExtra())) {
                    result += "ALTER TABLE " + masterCol.getTableName() + " CHANGE " + pie + masterCol.getColumnName() + pie + " " + pie
                        + masterCol.getColumnName() + pie + " " + masterCol.getColumnType() + " " + SqlUtil.nullable(masterCol.getIsNullable()) + " "
                        + SqlUtil.getDefault(masterCol) + " " + masterCol.getExtra() + " COMMENT '" + SqlUtil.comment(masterCol.getColumnComment())
                        + "' " +
                        // " "+after+" "+end;
                        end;
                }
            }
        }
        
        return result;
    }
    
    /**
     * 查询所有缺失的列
     * 
     * @author Liucl
     * @datetime 2016年9月8日 下午6:38:29
     */
    public String selectAllLostColumnSQL(SyncSchema syncSchema) {
        String result = "";
        List<SqlColumn> masterColumnList = syncMapper.selectAllColumns(syncSchema.getMasterSchema());
        List<SqlColumn> slaveColumnList = syncMapper.selectAllColumns(syncSchema.getSlaveSchema());
        Map<String, SqlColumn> slaveColumnMap = new HashMap<String, SqlColumn>();
        for (SqlColumn sColumn : slaveColumnList) {
            slaveColumnMap.put(sColumn.getTableName()+":"+sColumn.getColumnName(), sColumn);
        }
        // master 有 slave没有的 ，即 视为 lost，lostTable中不包含的才需要add，包含的已经通过createTable创建了。
        for (SqlColumn mColumn : masterColumnList) {
            if (!SqlUtil.filterTable(mColumn.getTableName())) {
                System.out.println(mColumn.getColumnName()+"--"+slaveColumnMap.get(mColumn.getColumnName()));
                if (slaveColumnMap.get(mColumn.getTableName()+":"+mColumn.getColumnName()) == null && !lostTableList.contains(mColumn.getTableName())) {
                    result +=
                        "ALTER TABLE " + mColumn.getTableName() + " ADD COLUMN " + pie + mColumn.getColumnName() + pie + " " + mColumn.getColumnType()
                            + " " + SqlUtil.nullable(mColumn.getIsNullable()) + " " + SqlUtil.getDefault(mColumn) + " " + mColumn.getExtra()
                            + " COMMENT '" + SqlUtil.comment(mColumn.getColumnComment()) + "' " + SqlUtil.after(mColumn, masterColumnList) + end;
                }
            }
        }
        return result;
        // List<SqlColumn> lostColumnList = syncMapper.selectUnExistColumns(syncSchema);
    }
    
    /**
     * 查询所有要移除的列，带不为空的数据条数
     * 
     * @author Liucl
     * @datetime 2016年9月8日 下午6:38:38
     */
    public String selectAllRemoveColumnSQL(SyncSchema syncSchema) {
        String result = "";
        List<SqlColumn> masterColumnList = syncMapper.selectAllColumns(syncSchema.getMasterSchema());
        List<SqlColumn> slaveColumnList = syncMapper.selectAllColumns(syncSchema.getSlaveSchema());
        Map<String, SqlColumn> masterColumnMap = new HashMap<String, SqlColumn>();
        for (SqlColumn mColumn : masterColumnList) {
            masterColumnMap.put(mColumn.getColumnName(), mColumn);
        }
        // slave 有 master没有的 ，即 视为 remove removeTable中不包含的才需要drop，包含的已经通过drop表删除了。
        for (SqlColumn sColumn : slaveColumnList) {
            if (!SqlUtil.filterTable(sColumn.getTableName())) {
                if (masterColumnMap.get(sColumn.getColumnName()) == null && !removeTableList.contains(sColumn.getTableName())) {
                    Integer count = syncMapper.selectColumnHasData(sColumn);
                    result += "/** 要删除的列 包含    " + count + " 条不为空的数据 */";
                    result += "ALTER TABLE " + sColumn.getTableName() + " DROP COLUMN " + pie + sColumn.getColumnName() + pie + end;
                }
            }
        }
        return result;
    }
    
    /**
     * 查要删除的索引
     * 
     * @author Liucl
     * @datetime 2016年9月9日 下午4:09:06
     */
    public String selectAllRemoveIndexSQL(SyncSchema syncSchema) {
        String result = "";
        List<SqlIndex> masterIndexList = syncMapper.selectAllIndexs(syncSchema.getMasterSchema());
        List<SqlIndex> slaveIndexList = syncMapper.selectAllIndexs(syncSchema.getSlaveSchema());
        
        // masterMap
        Map<String, List<SqlIndex>> masterIndexMap = new HashMap<String, List<SqlIndex>>();
        for (SqlIndex sqlIndex : masterIndexList) {
            List<SqlIndex> oneIndexList = masterIndexMap.get(sqlIndex.getINDEX_NAME());
            if (oneIndexList == null) {
                oneIndexList = new ArrayList<SqlIndex>();
            }
            oneIndexList.add(sqlIndex);
            masterIndexMap.put(sqlIndex.getINDEX_NAME(), oneIndexList);
        }
        // slaveMap
        Map<String, List<SqlIndex>> slaveIndexMap = new HashMap<String, List<SqlIndex>>();
        for (SqlIndex sqlIndex : slaveIndexList) {
            List<SqlIndex> oneIndexList = slaveIndexMap.get(sqlIndex.getINDEX_NAME());
            if (oneIndexList == null) {
                oneIndexList = new ArrayList<SqlIndex>();
            }
            oneIndexList.add(sqlIndex);
            slaveIndexMap.put(sqlIndex.getINDEX_NAME(), oneIndexList);
        }
        for (String sKey : slaveIndexMap.keySet()) {
            List<SqlIndex> oneIndexList = slaveIndexMap.get(sKey);
            String tableName = oneIndexList.get(0).getTABLE_NAME();
            String indexName = oneIndexList.get(0).getINDEX_NAME();
            if (masterIndexMap.get(sKey) == null && !removeTableList.contains(oneIndexList.get(0).getTABLE_NAME())) {
                result += "ALTER TABLE " + tableName + " DROP INDEX " + indexName + end;
            }
        }
        return result;
    }
    
    /**
     * 查询所有缺失的索引
     * 
     * @author Liucl
     * @datetime 2016年9月9日 下午1:40:34
     */
    public String selectAllLostIndexSQL(SyncSchema syncSchema) {
        String result = "";
        List<SqlIndex> masterIndexList = syncMapper.selectAllIndexs(syncSchema.getMasterSchema());
        List<SqlIndex> slaveIndexList = syncMapper.selectAllIndexs(syncSchema.getSlaveSchema());
        // masterMap
        Map<String, List<SqlIndex>> masterIndexMap = new HashMap<String, List<SqlIndex>>();
        for (SqlIndex sqlIndex : masterIndexList) {
            List<SqlIndex> oneIndexList = masterIndexMap.get(sqlIndex.getINDEX_NAME());
            if (oneIndexList == null) {
                oneIndexList = new ArrayList<SqlIndex>();
            }
            oneIndexList.add(sqlIndex);
            masterIndexMap.put(sqlIndex.getINDEX_NAME(), oneIndexList);
        }
        // slaveMap
        Map<String, List<SqlIndex>> slaveIndexMap = new HashMap<String, List<SqlIndex>>();
        for (SqlIndex sqlIndex : slaveIndexList) {
            List<SqlIndex> oneIndexList = slaveIndexMap.get(sqlIndex.getINDEX_NAME());
            if (oneIndexList == null) {
                oneIndexList = new ArrayList<SqlIndex>();
            }
            oneIndexList.add(sqlIndex);
            slaveIndexMap.put(sqlIndex.getINDEX_NAME(), oneIndexList);
        }
        // 对比是否有缺失的， master 有 slave没有的 即lost
        for (String mKey : masterIndexMap.keySet()) {
            boolean exist = false;
            for (String sKey : slaveIndexMap.keySet()) {
                if (StringUtils.equals(mKey, sKey)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                List<SqlIndex> lostIndexList = masterIndexMap.get(mKey);
                String tableName = lostIndexList.get(0).getTABLE_NAME();
                if (!lostTableList.contains(tableName)) {
                    result += SqlUtil.createIndex(lostIndexList) + end;
                }
            }
        }
        return result;
    }
    
}
