package com.roger.columnarticle.vo;

import java.sql.Timestamp;

public class ColumnArticleVo {

    private Integer artNo;
    private Integer admNo;
    private String artTitle;
    private String artContent;
    private Timestamp artTime;
    private Integer artCatNo;
    private Byte artStat;

    public Integer getArtNo() {
        return artNo;
    }

    public void setArtNo(Integer artNo) {
        this.artNo = artNo;
    }

    public Integer getAdmNo() {
        return admNo;
    }

    public void setAdmNo(Integer admNo) {
        this.admNo = admNo;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public Timestamp getArtTime() {
        return artTime;
    }

    public void setArtTime(Timestamp artTime) {
        this.artTime = artTime;
    }

    public Integer getArtCatNo() {
        return artCatNo;
    }

    public void setArtCatNo(Integer artCatNo) {
        this.artCatNo = artCatNo;
    }

    public Byte getArtStat() {
        return artStat;
    }

    public void setArtStat(Byte artStat) {
        this.artStat = artStat;
    }
}
