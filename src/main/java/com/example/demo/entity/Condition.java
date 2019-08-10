package com.example.demo.entity;



/*
* 保存搜索条件的实体类
* */
public class Condition {
   /* ID=#{ID}
    or Email=#{eMail}
    or status=#{status}*/
   private String ID;
   private String eMail;
   private String status;
    private String barCode;
    private String identity;
    private String name;
    private String phone;
    private String dateS;//开始日期
    private String dateE;//结束日期
    private String createdBy;
    private String modifiedBy;
    private String modifiedOn;//修改日期

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateS() {
        return dateS;
    }

    public void setDateS(String dateS) {
        this.dateS = dateS;
    }

    public String getDateE() {
        return dateE;
    }

    public void setDateE(String dateE) {
        this.dateE = dateE;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "ID='" + ID + '\'' +
                ", eMail='" + eMail + '\'' +
                ", status='" + status + '\'' +
                ", barCode='" + barCode + '\'' +
                ", identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dateS='" + dateS + '\'' +
                ", dateE='" + dateE + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn='" + modifiedOn + '\'' +
                '}';
    }
}
