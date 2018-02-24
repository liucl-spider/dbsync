package com.acewill.dbsync.entity;

import java.util.List;

public class Table {
    private String tableComment;
    
    private String tableName;
    
    private List<TableColumn> columns;
    
    private String primaryKey;
    
    private String index;
    
    private String others;
    
    private String trigger;
    
    public String getTableComment() {
        return tableComment;
    }
    
    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }
    
    public String getTableName() {
        return tableName;
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public List<TableColumn> getColumns() {
        return columns;
    }
    
    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }
    
    public String getPrimaryKey() {
        return primaryKey;
    }
    
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    public String getIndex() {
        return index;
    }
    
    public void setIndex(String index) {
        this.index = index;
    }
    
    public String getOthers() {
        return others;
    }
    
    public void setOthers(String others) {
        this.others = others;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
    
}
