package com.roger.columnreply.vo;

import java.sql.Timestamp;

public class ColumnReplyVo implements java.io.Serializable {

    private Integer columnReplyNo;
    private Integer artNo;
    private Integer memNo;
    private String comContent;
    private Timestamp comTime;
    private Byte comStat;

    public Integer getColumnReplyNo() {
        return columnReplyNo;
    }

    public void setColumnReplyNo(Integer columnReplyNo) {
        this.columnReplyNo = columnReplyNo;
    }

    public Integer getArtNo() {
        return artNo;
    }

    public void setArtNo(Integer artNo) {
        this.artNo = artNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getComTime() {
        return comTime;
    }

    public void setComTime(Timestamp comTime) {
        this.comTime = comTime;
    }

    public Byte getComStat() {
        return comStat;
    }

    public void setComStat(Byte comStat) {
        this.comStat = comStat;
    }
}
