package com.firesnoopy.studiotimebooking.entity;


import com.firesnoopy.studioinfo.entity.StudioInfo;
import com.firesnoopy.studioorder.entity.StudioOrder;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "StudioTimeBooking")
public class StudioTimeBooking {
    @Id
    @Column(name = "sTimeNo")
    private Integer sTimeNo;
    @ManyToOne
    @JoinColumn(name = "sOrdNo", referencedColumnName = "sOrdNo")
    private StudioOrder studioOrder;
    @ManyToOne
    @JoinColumn(name = "sNo", referencedColumnName = "sNo")
    private StudioInfo studioInfo;
    @Column(name = "closeDate")
    private Date closeDate;
    @Column(name = "closeTimeMorning")
    private Byte closeTimeMorning;
    @Column(name = "closeTimeAfternoon")
    private Byte closeTimeAfternoon;
    @Column(name = "closeTimeNight")
    private Byte closeTimeNight;

    public Integer getsTimeNo() {
        return sTimeNo;
    }

    public void setsTimeNo(Integer sTimeNo) {
        this.sTimeNo = sTimeNo;
    }

    public StudioOrder getStudioOrder() {
        return studioOrder;
    }

    public void setStudioOrder(StudioOrder studioOrder) {
        this.studioOrder = studioOrder;
    }

    public StudioInfo getStudioInfo() {
        return studioInfo;
    }

    public void setStudioInfo(StudioInfo studioInfo) {
        this.studioInfo = studioInfo;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Byte getCloseTimeMorning() {
        return closeTimeMorning;
    }

    public void setCloseTimeMorning(Byte closeTimeMorning) {
        this.closeTimeMorning = closeTimeMorning;
    }

    public Byte getCloseTimeAfternoon() {
        return closeTimeAfternoon;
    }

    public void setCloseTimeAfternoon(Byte closeTimeAfternoon) {
        this.closeTimeAfternoon = closeTimeAfternoon;
    }

    public Byte getCloseTimeNight() {
        return closeTimeNight;
    }

    public void setCloseTimeNight(Byte closeTimeNight) {
        this.closeTimeNight = closeTimeNight;
    }
}
