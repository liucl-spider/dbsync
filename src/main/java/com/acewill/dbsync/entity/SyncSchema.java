package com.acewill.dbsync.entity;
/**
 * 数据库对比主从数据库名称
 * @author Liucl
 * @datetime 2016年9月7日 下午4:29:48
 */
public class SyncSchema {
    
    private String masterSchema;//主数据库名称
    private String slaveSchema;//从数据库名称
    
    public SyncSchema(){
        
    }
    
    public SyncSchema(String masterSchema, String slaveSchema){
        this.masterSchema = masterSchema;
        this.slaveSchema = slaveSchema;
    }
    
    public String getMasterSchema() {
        return masterSchema;
    }
    public void setMasterSchema(String masterSchema) {
        this.masterSchema = masterSchema;
    }
    public String getSlaveSchema() {
        return slaveSchema;
    }
    public void setSlaveSchema(String slaveSchema) {
        this.slaveSchema = slaveSchema;
    }
    
}
