package com.yu.rentset.model;

public class RentSet implements java.io.Serializable{
    private Integer rOrdNo;
    private String rSetName;
    private Byte rSetDays;

    public Integer getrOrdNo() {
        return rOrdNo;
    }

    public void setrOrdNo(Integer rOrdNo) {
        this.rOrdNo = rOrdNo;
    }

    public String getrSetName() {
        return rSetName;
    }

    public void setrSetName(String rSetName) {
        this.rSetName = rSetName;
    }

    public Byte getrSetDays() {
        return rSetDays;
    }

    public void setrSetDays(Byte rSetDays) {
        this.rSetDays = rSetDays;
    }
}
