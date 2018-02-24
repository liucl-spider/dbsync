package com.acewill.dbsync.entity;

import java.io.Serializable;
import java.util.Date;

/***
 * 编码表
 * @author Liucl
 * @datetime 2016年9月13日 下午3:19:16
 */
public class CodeContent implements Serializable{
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    
    /* 自增主键 */
    private Integer ID;
    
    /* 编码名 */
    private String codeName;
    
    /* 编码值 */
    private String code;
    
    /* 定义ID */
    private Integer difintionID;
    
    /* 排序号 */
    private Integer orderNum;
    
    /* 创建日期 */
    private Date createTime;
    
    /* 描述 */
    private String des;
    
    /* 是否有效 */
    private Byte valid;
    
    private Byte flag;//1为内置项
    
    private String defintionCode;
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getCodeName() {
        return codeName;
    }
    
    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    
    public Integer getDifintionID() {
        return difintionID;
    }
    
    public void setDifintionID(Integer difintionID) {
        this.difintionID = difintionID;
    }
    
    public Integer getOrderNum() {
        return orderNum;
    }
    
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
    
    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getDefintionCode() {
        return defintionCode;
    }

    public void setDefintionCode(String defintionCode) {
        this.defintionCode = defintionCode;
    }
    
}
