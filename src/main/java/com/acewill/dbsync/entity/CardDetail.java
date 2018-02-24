package com.acewill.dbsync.entity;

import java.io.Serializable;
import java.util.Date;

public class CardDetail implements Serializable {
    /**
     * @author shangb
     * @date 2016年7月4日 上午11:19:38
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Integer ID;

    private String name;

    private String alias;

    private String info;

    private String ctrl;

    private Integer cardID;

    private Date createTime;

    private String des;

    private Byte valid;
    
    private String cardName;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getCtrl() {
        return ctrl;
    }

    public void setCtrl(String ctrl) {
        this.ctrl = ctrl == null ? null : ctrl.trim();
    }

    public Integer getCardID() {
        return cardID;
    }

    public void setCardID(Integer cardID) {
        this.cardID = cardID;
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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", name=").append(name);
        sb.append(", alias=").append(alias);
        sb.append(", info=").append(info);
        sb.append(", ctrl=").append(ctrl);
        sb.append(", cardID=").append(cardID);
        sb.append(", createTime=").append(createTime);
        sb.append(", des=").append(des);
        sb.append(", valid=").append(valid);
        sb.append("]");
        return sb.toString();
    }
}