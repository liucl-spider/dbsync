package com.acewill.dbsync.entity;

import java.io.Serializable;
import java.util.Date;

public class BtnPage implements Serializable {
    
    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    private Integer ID;
    
    private Integer moduleID;
    
    private String pageName;
    
    private String pageCode;
    
    private Date createTime;
    
    private String des;
    
    private Byte valid;
    
    private String moduleName;
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public Integer getModuleID() {
        return moduleID;
    }
    
    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }
    
    public String getPageCode() {
        return pageCode;
    }
    
    public void setPageCode(String pageCode) {
        this.pageCode = pageCode == null ? null : pageCode.trim();
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
    
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", moduleID=").append(moduleID);
        sb.append(", pageName=").append(pageName);
        sb.append(", pageCode=").append(pageCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", des=").append(des);
        sb.append(", valid=").append(valid);
        sb.append("]");
        return sb.toString();
    }
}