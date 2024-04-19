package com.chihyunro.mycoupon.model;

import java.sql.Timestamp;

public class Mycoupon implements java.io.Serializable{
    private Integer coupNo;
    private Integer memNo;
    private Byte coupUsedStat;
    private String coupInfo;
    private Timestamp coupExpDate;

    public Integer getCoupNo() {
        return coupNo;
    }

    public void setCoupNo(Integer coupNo) {
        this.coupNo = coupNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Byte getCoupUsedStat() {
        return coupUsedStat;
    }

    public void setCoupUsedStat(Byte coupUsedStat) {
        this.coupUsedStat = coupUsedStat;
    }

    public String getCoupInfo() {
        return coupInfo;
    }

    public void setCoupInfo(String coupInfo) {
        this.coupInfo = coupInfo;
    }

    public Timestamp getCoupExpDate() {
        return coupExpDate;
    }

    public void setCoupExpDate(Timestamp coupExpDate) {
        this.coupExpDate = coupExpDate;
    }
}
