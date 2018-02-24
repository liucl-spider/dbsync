package com.acewill.dbsync.entity;
/**
 * sql对象-索引
 * @author Liucl
 * @datetime 2016年9月9日 下午1:11:48
 */
public class SqlIndex {
    private String TABLE_SCHEMA;
    private String TABLE_NAME;
    private String NON_UNIQUE;//0唯一 1非唯一
    private String INDEX_NAME;
    private String SEQ_IN_INDEX;//索引列顺序
    private String COLUMN_NAME;
    
    public String getTABLE_SCHEMA() {
        return TABLE_SCHEMA;
    }
    public void setTABLE_SCHEMA(String tABLE_SCHEMA) {
        TABLE_SCHEMA = tABLE_SCHEMA;
    }
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
    public void setTABLE_NAME(String tABLE_NAME) {
        TABLE_NAME = tABLE_NAME;
    }
    public String getNON_UNIQUE() {
        return NON_UNIQUE;
    }
    public void setNON_UNIQUE(String nON_UNIQUE) {
        NON_UNIQUE = nON_UNIQUE;
    }
    public String getINDEX_NAME() {
        return INDEX_NAME;
    }
    public void setINDEX_NAME(String iNDEX_NAME) {
        INDEX_NAME = iNDEX_NAME;
    }
    public String getSEQ_IN_INDEX() {
        return SEQ_IN_INDEX;
    }
    public void setSEQ_IN_INDEX(String sEQ_IN_INDEX) {
        SEQ_IN_INDEX = sEQ_IN_INDEX;
    }
    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }
    public void setCOLUMN_NAME(String cOLUMN_NAME) {
        COLUMN_NAME = cOLUMN_NAME;
    }
    
    
}
