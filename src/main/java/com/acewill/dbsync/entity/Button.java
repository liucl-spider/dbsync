package com.acewill.dbsync.entity;

import java.io.Serializable;
import java.util.Date;

public class Button implements Serializable {
    
    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    private Integer ID;
    
    private String btnName;
    
    private String btnCode;
    
    private Integer btnPageID;
    
    private Date createTime;
    
    private String des;
    
    private Byte valid;
    
    private String pageName;
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getBtnName() {
        return btnName;
    }
    
    public void setBtnName(String btnName) {
        this.btnName = btnName == null ? null : btnName.trim();
    }
    
    public String getBtnCode() {
        return btnCode;
    }
    
    public void setBtnCode(String btnCode) {
        this.btnCode = btnCode == null ? null : btnCode.trim();
    }
    
    public Integer getBtnPageID() {
        return btnPageID;
    }
    
    public void setBtnPageID(Integer btnPageID) {
        this.btnPageID = btnPageID;
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
    
    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", btnName=").append(btnName);
        sb.append(", btnCode=").append(btnCode);
        sb.append(", btnPageID=").append(btnPageID);
        sb.append(", createTime=").append(createTime);
        sb.append(", des=").append(des);
        sb.append(", valid=").append(valid);
        sb.append("]");
        return sb.toString();
    }
}