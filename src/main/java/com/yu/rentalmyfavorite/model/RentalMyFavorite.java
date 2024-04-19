package com.yu.rentalmyfavorite.model;

import java.sql.Timestamp;

public class RentalMyFavorite implements java.io.Serializable{
    private Integer rNo;
    private Integer memNo;
    private Timestamp rFavTime;

    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Timestamp getrFavTime() {
        return rFavTime;
    }

    public void setrFavTime(Timestamp rFavTime) {
        this.rFavTime = rFavTime;
    }
}
