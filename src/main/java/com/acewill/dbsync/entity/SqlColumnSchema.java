package com.acewill.dbsync.entity;
/**
 * 列对比
 * @author Liucl
 * @datetime 2016年9月7日 下午4:42:48
 */
public class SqlColumnSchema {
    
    private SqlColumn master;//主表结构
    private SqlColumn slave;//从表结构
    
    public SqlColumn getMaster() {
        return master;
    }
    public void setMaster(SqlColumn master) {
        this.master = master;
    }
    public SqlColumn getSlave() {
        return slave;
    }
    public void setSlave(SqlColumn slave) {
        this.slave = slave;
    }
    
    
}
