package com.acewill.dbsync.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 编码表
 * @author Liucl
 * @datetime 2016年9月13日 下午3:18:21
 */
public class CodeDefintion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /* 自增主键 */
    private Integer ID;
    
    /* 视图编码 */
    private String defintionCode;
    
    /* 定义名 */
    private String difintionName;
    
    /* 父ID */
    private Integer parentID;
    
    /* 视图类型 */
    private String viewType;
    
    /* 创建日期 */
    private Date createTime;
    
    /* 描述 */
    private String des;
    
    /* 是否有效 */
    private Byte valid;
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getDefintionCode() {
        return defintionCode;
    }
    
    public void setDefintionCode(String defintionCode) {
        this.defintionCode = defintionCode == null ? null : defintionCode.trim();
    }
    
    public String getDifintionName() {
        return difintionName;
    }
    
    public void setDifintionName(String difintionName) {
        this.difintionName = difintionName == null ? null : difintionName.trim();
    }
    
    public Integer getParentID() {
        return parentID;
    }
    
    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }
    
    public String getViewType() {
        return viewType;
    }
    
    public void setViewType(String viewType) {
        this.viewType = viewType == null ? null : viewType.trim();
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getDes() {
        return des;
    }
    
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
    
    public Byte getValid() {
        return valid;
    }
    
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}
