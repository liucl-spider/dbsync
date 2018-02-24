package com.acewill.dbsync.dao;

import java.util.List;
import java.util.Map;

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

public interface SyncMapper {
    /**
     * 查询 不存在的表名称列表
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午3:23:07
     */
    public List<String> selectUnExistTableNameList(SyncSchema syncSchema);
    
    /**
     * 查询某个数据库的所有触发器名称
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午6:43:44
     */
    public List<String> selectAllTrigger(String schema);
    
    public List<String> selectTableTrigger(Map<String, String> params);
    
    /**
     * 查询某个数据库的所有方法名称
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午6:44:03
     */
    public List<String> selectAllFunction(String schema);
    
    /**
     * 查询某个数据库所有存储过程名称
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午6:44:17
     */
    public List<String> selectAllProcedure(String schema);
    
    public List<Map<String, String>> selectAllTable(String schema);
    
    /**
     * 查询 创建 表、视图、存储过程、函数、触发器 的语句
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午3:23:20
     */
    public Map<String, String> selectCreateSqlObj(SqlObject sqlObj);
    
    /**
     * 执行创建sql对象 语句
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午3:25:49
     */
    public int runCreateSql(String sql);
    
    /**
     * 查询不存在的列
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午3:55:23
     */
    public List<SqlColumn> selectUnExistColumns(SyncSchema syncSchema);
    
    /**
     * 查询所有列名称相同的列 列表，做对比
     * 
     * @author Liucl
     * @datetime 2016年9月7日 下午4:13:03
     */
    public List<SqlColumnSchema> selectChangedColumns(SyncSchema syncSchema);
    
    /**
     * 查询数据库的所有列
     * @author Liucl
     * @datetime 2016年9月8日 下午6:35:51
     */
    public List<SqlColumn> selectAllColumns(String schema);
    /**
     * 查询当前列是否有不为空的数据
     * @author Liucl
     * @datetime 2016年9月8日 下午6:35:48
     */
    public Integer selectColumnHasData(SqlColumn sColumn);
    /**
     * 查询所有索引
     * @author Liucl
     * @datetime 2016年9月13日 下午3:47:52
     */
    public List<SqlIndex> selectAllIndexs(String schema);
    /**
     * 查询缺失的codedefintion
     * @author Liucl
     * @datetime 2016年9月13日 下午3:48:01
     */
    public List<CodeDefintion> selectUnExistCodeDefinaList(SyncSchema syncSchema);
    /**
     * 查询缺失的 codecontent
     * @author Liucl
     * @datetime 2016年9月13日 下午3:48:18
     */
    public List<CodeContent> selectUnExistCodeContentList(SyncSchema syncSchema);
    /**
     * 查 按钮表
     * @author Liucl
     * @datetime 2016年9月14日 下午6:25:49
     */
    public List<Button> selectAllButton(String schema);
    /**
     * 查按钮页面表
     * @author Liucl
     * @datetime 2016年9月14日 下午6:26:01
     */
    public List<BtnPage> selectAllBtnPage(String schema);
    /**
     * 查 菜单表
     * @author Liucl
     * @datetime 2016年9月14日 下午6:26:10
     */
    public List<SysMenu> selectAllSysMenu(String schema);
    /**
     * 查模块表
     * @author Liucl
     * @datetime 2016年9月14日 下午6:26:17
     */
    public List<SysModule> selectAllSysModule(String schema);
    /**
     * 查卡片表
     * @author Liucl
     * @datetime 2016年11月15日 下午5:51:02
     */
    public List<Card> selectAllCard(String masterSchema);
    /**
     * 查卡片详情表
     * @author Liucl
     * @datetime 2016年11月15日 下午6:01:15
     */
    public List<CardDetail> selectAllCardDetail(String masterSchema);
    
}
