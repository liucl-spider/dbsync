package com.acewill.dbsync.entity;
/**
 * sql对象
 * @author Liucl
 * @datetime 2016年9月7日 下午4:50:04
 */
public class SqlObject {
    
    private String schema;//数据库名称
    private String sqlObjType;//类型
    private String sqlObjName;//名称
    
    public SqlObject(){
        
    }
    
    public SqlObject(String schema, String sqlObjType, String sqlObjName){
        this.schema = schema;
        this.sqlObjType = sqlObjType;
        this.sqlObjName = sqlObjName;
    }
    
    public String getSqlObjType() {
        return sqlObjType;
    }
    public void setSqlObjType(String sqlObjType) {
        this.sqlObjType = sqlObjType;
    }
    public String getSqlObjName() {
        return sqlObjName;
    }
    public void setSqlObjName(String sqlObjName) {
        this.sqlObjName = sqlObjName;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
    
    
}
