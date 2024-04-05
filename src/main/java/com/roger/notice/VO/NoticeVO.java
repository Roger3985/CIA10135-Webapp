package com.roger.notice.VO;

import java.sql.Timestamp;

public class NoticeVO implements java.io.Serializable {

    private Integer motNo;
    private Integer memNo;
    private String notContent;
    private Timestamp notTime;
    private Byte notStat;

    public Integer getMotNo() {
        return motNo;
    }

    public void setMotNo(Integer motNo) {
        this.motNo = motNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public String getNotContent() {
        return notContent;
    }

    public void setNotContent(String notContent) {
        this.notContent = notContent;
    }

    public Timestamp getNotTime() {
        return notTime;
    }

    public void setNotTime(Timestamp notTime) {
        this.notTime = notTime;
    }

    public Byte getNotStat() {
        return notStat;
    }

    public void setNotStat(Byte notStat) {
        this.notStat = notStat;
    }
}
