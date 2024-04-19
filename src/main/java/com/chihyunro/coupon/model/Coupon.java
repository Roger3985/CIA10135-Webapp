package com.chihyunro.coupon.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Coupon implements java.io.Serializable{
    private Integer coupNo;
    private String coupName;
    private String coupCond;
    private BigDecimal coupDisc;
    private Timestamp coupAddDate;
    private Timestamp coupExpDate;
    private Timestamp coupRelDate;
    private Byte coupRealStat;

    public Integer getCoupNo() {
        return coupNo;
    }

    public void setCoupNo(Integer coupNo) {
        this.coupNo = coupNo;
    }

    public String getCoupName() {
        return coupName;
    }

    public void setCoupName(String coupName) {
        this.coupName = coupName;
    }

    public String getCoupCond() {
        return coupCond;
    }

    public void setCoupCond(String coupCond) {
        this.coupCond = coupCond;
    }

    public BigDecimal getCoupDisc() {
        return coupDisc;
    }

    public void setCoupDisc(BigDecimal coupDisc) {
        this.coupDisc = coupDisc;
    }

    public Timestamp getCoupAddDate() {
        return coupAddDate;
    }

    public void setCoupAddDate(Timestamp coupAddDate) {
        this.coupAddDate = coupAddDate;
    }

    public Timestamp getCoupExpDate() {
        return coupExpDate;
    }

    public void setCoupExpDate(Timestamp coupExpDate) {
        this.coupExpDate = coupExpDate;
    }

    public Timestamp getCoupRelDate() {
        return coupRelDate;
    }

    public void setCoupRelDate(Timestamp coupRelDate) {
        this.coupRelDate = coupRelDate;
    }

    public Byte getCoupRealStat() {
        return coupRealStat;
    }

    public void setCoupRealStat(Byte coupRealStat) {
        this.coupRealStat = coupRealStat;
    }
}
