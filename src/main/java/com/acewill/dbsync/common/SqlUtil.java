package com.acewill.dbsync.common;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.acewill.dbsync.entity.SqlColumn;
import com.acewill.dbsync.entity.SqlIndex;
import com.alibaba.druid.util.StringUtils;
/**
 * sql语句处理
 * @author Liucl
 * @datetime 2016年9月8日 下午6:22:20
 */
public class SqlUtil {
    /**
     * 拼接after
     * @author Liucl
     * @datetime 2016年9月8日 下午6:21:28
     */
    public static String after(SqlColumn mColumn, List<SqlColumn> columnList) {
        Integer position = mColumn.getOrdinalPosition();
        position -= 1;
        if (position > 0) {
            for (SqlColumn column : columnList) {
                if (column.getOrdinalPosition().equals(position) && column.getTableName().equals(mColumn.getTableName())) {
                    return "AFTER " + column.getColumnName();
                }
            }
        }
        return "";
    }
    /**
     * 拼接是否为空
     * @author Liucl
     * @datetime 2016年9月8日 下午6:21:36
     */
    public static String nullable(String nullable) {
        if (nullable.equals("NO")) {
            return "NOT NULL";
        }
        return "";
    }
    
    
    public static String comment(String comment){
        if(!StringUtils.isEmpty(comment)){
            comment = comment.replace("'", "\\'");
        }
        return comment;
    }
    /**
     * 拼接默认值
     * @author Liucl
     * @datetime 2016年9月8日 下午6:21:45
     */
    public static String getDefault(SqlColumn masterCol) {
        String intReg = "int|double|float|boolean|timestamp";
        Pattern p = Pattern.compile(intReg);
        if (!StringUtils.isEmpty(masterCol.getColumnDefault())) {
            Matcher m = p.matcher(masterCol.getColumnType());
            if (m.find()) {
                return "DEFAULT " + masterCol.getColumnDefault();
            } else {
                return "DEFAULT '" + masterCol.getColumnDefault() + "'";
            }
        }
        return "";
    }
    
    /**
     * 拼接创建索引语句
     * @author Liucl
     * @datetime 2016年9月9日 下午1:40:14
     */
    public static String createIndex(List<SqlIndex> subIndexList) {
        String result = "";
        if(subIndexList!=null && subIndexList.size()>0){
            String cols = "(";
            for(SqlIndex index : subIndexList){
                cols += "`"+index.getCOLUMN_NAME()+"`,";
            }
            if(cols.endsWith(",")){
                cols = cols.substring(0, cols.length()-1);
            }
            cols+=")";
            
//            String schema = subIndexList.get(0).getTABLE_SCHEMA();
            String tableName = subIndexList.get(0).getTABLE_NAME();
            String unique = subIndexList.get(0).getNON_UNIQUE();
            String indexName = subIndexList.get(0).getINDEX_NAME();
//            String colSeq = subIndexList.get(0).getSEQ_IN_INDEX();
            result = "ALTER TABLE "+tableName+" ADD ";
            if(StringUtils.equals(unique, "0") && StringUtils.equals(indexName, "PRIMARY")){
                result += "PRIMARY KEY "+cols;
            }else if(StringUtils.equals(unique, "0") && !StringUtils.equals(indexName, "PRIMARY")){
                result += "UNIQUE "+cols;
            }else{
                result += "INDEX "+indexName+" "+cols;
            }
        }
        return result;
    }
    /**
     * 过滤表
     * @author Liucl
     * @datetime 2016年9月27日 上午10:39:45
     */
    public static boolean filterTable(String tableName){
        String[] filterList = {"ext_employee"};
        for(String filter : filterList){
            if(StringUtils.equals(filter, tableName)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String intReg = "int|double|float|boolean";
        Pattern p = Pattern.compile(intReg);
        Matcher m = p.matcher("timestamp");
        if (m.find()) {
            System.out.println("match");
        }else{
            System.out.println("no");
        }
    }
}
