package com.acewill.dbsync.entity;

import java.io.Serializable;
import java.util.Date;

public class SysMenu implements Serializable {
    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    private Integer ID;
    
    private Integer moduleID;
    
    private String menuName;
    
    private Integer parentID;
    
    private String imagUrl;
    
    private Integer orderNum;
    
    private String url;
    
    private Integer isLeft;
    
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
    
    public String getMenuName() {
        return menuName;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }
    
    public Integer getParentID() {
        return parentID;
    }
    
    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }
    
    public String getImagUrl() {
        return imagUrl;
    }
    
    public void setImagUrl(String imagUrl) {
        this.imagUrl = imagUrl == null ? null : imagUrl.trim();
    }
    
    public Integer getOrderNum() {
        return orderNum;
    }
    
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
    
    public Integer getIsLeft() {
        return isLeft;
    }
    
    public void setIsLeft(Integer isLeft) {
        this.isLeft = isLeft;
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
        sb.append(", menuName=").append(menuName);
        sb.append(", parentID=").append(parentID);
        sb.append(", imagUrl=").append(imagUrl);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", url=").append(url);
        sb.append(", isLeft=").append(isLeft);
        sb.append(", createTime=").append(createTime);
        sb.append(", des=").append(des);
        sb.append(", valid=").append(valid);
        sb.append("]");
        return sb.toString();
    }
}