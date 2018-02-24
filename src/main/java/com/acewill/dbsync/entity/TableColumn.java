package com.acewill.dbsync.entity;

public class TableColumn {
    private String columnName;
    private String columnType;
    private String defaultStr;
    private String comment;
    
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getColumnType() {
        return columnType;
    }
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    public String getDefaultStr() {
        return defaultStr;
    }
    public void setDefaultStr(String defaultStr) {
        this.defaultStr = defaultStr;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
