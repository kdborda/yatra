package com.example.yatra_receipt;

import io.realm.RealmObject;

public class Data extends RealmObject {
    long receiptNo;
    String name, gam, mobileNo, tithiYatra, people, children, amount, deposit, baki, svikarnar;
    String Yatri_name,age,gender,from_station,to_sation,desc;
    String createdData;
    long createdTime;

    public String getYatri_name() {
        return Yatri_name;
    }

    public void setYatri_name(String yatri_name) {
        Yatri_name = yatri_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFrom_station() {
        return from_station;
    }

    public void setFrom_station(String from_station) {
        this.from_station = from_station;
    }

    public String getTo_sation() {
        return to_sation;
    }

    public void setTo_sation(String to_sation) {
        this.to_sation = to_sation;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGam() {
        return gam;
    }

    public void setGam(String gam) {
        this.gam = gam;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTithiYatra() {
        return tithiYatra;
    }

    public void setTithiYatra(String tithiYatra) {
        this.tithiYatra = tithiYatra;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getBaki() {
        return baki;
    }

    public String getSvikarnar() {
        return svikarnar;
    }

    public void setSvikarnar(String svikarnar) {
        this.svikarnar = svikarnar;
    }

    public void setBaki(String baki) {
        this.baki = baki;
    }

    public String getCreatedData() {
        return createdData;
    }

    public void setCreatedData(String createdData) {
        this.createdData = createdData;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
}
