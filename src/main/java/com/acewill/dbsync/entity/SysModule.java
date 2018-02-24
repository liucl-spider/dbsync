package com.acewill.dbsync.entity;

import java.io.Serializable;
import java.util.Date;

public class SysModule implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    
    /* 自增主键 */
    private Integer ID;
    
    /* 模块名称 */
    private String moduleName;
    
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
    
    public String getModuleName() {
        return moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
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