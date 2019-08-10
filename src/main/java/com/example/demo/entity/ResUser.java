package com.example.demo.entity;

import java.util.Date;

public class ResUser {
    private int ID;
    private String barCode;
    private String identity;
    private String name;
    private String age;
    private String sex;
    private String province;
    private String city;
    private String area;
    private String addr;
    private String eMail;
    private String bornDate;
    private String isMarry;
    private String nation;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String account;
    private String date;
    private String reserved;
    private String unreserved;
    private String arrived;
    private String unarrived;
    private String combinItemCode;
    private String combinItemName;
    private String phone;
    private String status;
    private String resDate;
    private String description;

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(String isMarry) {
        this.isMarry = isMarry;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getUnreserved() {
        return unreserved;
    }

    public void setUnreserved(String unreserved) {
        this.unreserved = unreserved;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }

    public String getUnarrived() {
        return unarrived;
    }

    public void setUnarrived(String unarrived) {
        this.unarrived = unarrived;
    }

    public String getCombinItemCode() {
        return combinItemCode;
    }

    public void setCombinItemCode(String combinItemCode) {
        this.combinItemCode = combinItemCode;
    }

    public String getCombinItemName() {
        return combinItemName;
    }

    public void setCombinItemName(String combinItemName) {
        this.combinItemName = combinItemName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ResUser{" +
                "ID=" + ID +
                ", barCode='" + barCode + '\'' +
                ", identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", addr='" + addr + '\'' +
                ", eMail='" + eMail + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", isMarry='" + isMarry + '\'' +
                ", nation='" + nation + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", account='" + account + '\'' +
                ", date='" + date + '\'' +
                ", reserved='" + reserved + '\'' +
                ", unreserved='" + unreserved + '\'' +
                ", arrived='" + arrived + '\'' +
                ", unarrived='" + unarrived + '\'' +
                ", combinItemCode='" + combinItemCode + '\'' +
                ", combinItemName='" + combinItemName + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", resDate='" + resDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
