package com.chihyunro.servicerecord.model;

import java.sql.Date;

public class ServiceRecord implements java.io.Serializable{
    private Integer recordNo;
    private Integer admNo;
    private Integer memNo;
    private Date recordTime;
    private String recordContent;
    private Byte speaker;

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public Integer getAdmNo() {
        return admNo;
    }

    public void setAdmNo(Integer admNo) {
        this.admNo = admNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public Byte getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Byte speaker) {
        this.speaker = speaker;
    }
}
