package com.acewill.dbsync.entity;
/**
 * 数据库列信息
 * @author Liucl
 * @datetime 2016年9月7日 下午3:54:39
 */
public class SqlColumn {
    
    private String tableCatalog;    //def
    private String tableSchema;     //数据库名
    private String tableName;       //表名
    private String columnName;      //列名称
    private Integer ordinalPosition;//排序号
    private String columnDefault;   //列默认值
    private String isNullable;      //是否可为空NO YES
    private String dataType;        //列类型  varchar/timestamp/tinyint/int
    private Integer characterLength;//长度
    private String columnType;      //列类型 带长度 varchar(255)
    private String extra;           //auto_increment
    private String columnComment;   //列备注
    
    
    public String getTableCatalog() {
        return tableCatalog;
    }
    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }
    public String getTableSchema() {
        return tableSchema;
    }
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }
    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }
    public String getColumnDefault() {
        return columnDefault;
    }
    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }
    public String getIsNullable() {
        return isNullable;
    }
    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public Integer getCharacterLength() {
        return characterLength;
    }
    public void setCharacterLength(Integer characterLength) {
        this.characterLength = characterLength;
    }
    public String getColumnType() {
        return columnType;
    }
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    public String getExtra() {
        return extra;
    }
    public void setExtra(String extra) {
        this.extra = extra;
    }
    public String getColumnComment() {
        return columnComment;
    }
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
    
    
}
