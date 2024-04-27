package com.firesnoopy.studioorder.entity;


import com.firesnoopy.studioinfo.entity.StudioInfo;
import com.firesnoopy.studiotimebooking.entity.StudioTimeBooking;
import com.ren.administrator.entity.Administrator;
import com.roger.member.entity.Member;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "StudioOrder")
public class StudioOrder {
    @Id
    @Column(name = "sOrdNo")
    private Integer sOrdNo;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "sNo", referencedColumnName = "sNo")
    private StudioInfo studioInfo;
    @ManyToOne
    @JoinColumn(name = "admNo", referencedColumnName = "admNo")
    private Administrator administrator;
    @Column(name = "bookedDate")
    private Date bookedDate;
    @Column(name = "bookedTimeMorning")
    private Byte bookedTimeMorning;
    @Column(name = "bookedTimeAfternoon")
    private Byte bookedTimeAfternoon;
    @Column(name = "bookedTimeNight")
    private Byte bookedTimeNight;
    @Column(name = "sOrdTime")
    private Timestamp sOrdTime;
    @Column(name = "sOrdStat")
    private Byte sOrdStat;
    @Column(name = "sTtlPrice")
    private BigDecimal sTtlPrice;
    @Column(name = "sDepPrice")
    private BigDecimal sDepPrice;
    @Column(name = "sByrName")
    private String sByrName;
    @Column(name = "sByrPhone")
    private String sByrPhone;
    @Column(name = "sByrEmail")
    private String sByrEmail;
    @Column(name = "sPayMethod")
    private Byte sPayMethod;
    @Column(name = "sPayStat")
    private Byte sPayStat;
    @Column(name = "checkInStat")
    private Byte checkInStat;
    @Column(name = "sReturnMark")
    private String sReturnMark;
    @Column(name = "sCompensation")
    private BigDecimal sCompensation;
    @OneToMany(mappedBy = "studioOrder", cascade = CascadeType.ALL)
    private Set<StudioTimeBooking> studioTimeBookings;

    public Integer getsOrdNo() {
        return sOrdNo;
    }

    public void setsOrdNo(Integer sOrdNo) {
        this.sOrdNo = sOrdNo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public StudioInfo getStudioInfo() {
        return studioInfo;
    }

    public void setStudioInfo(StudioInfo studioInfo) {
        this.studioInfo = studioInfo;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public Byte getBookedTimeMorning() {
        return bookedTimeMorning;
    }

    public void setBookedTimeMorning(Byte bookedTimeMorning) {
        this.bookedTimeMorning = bookedTimeMorning;
    }

    public Byte getBookedTimeAfternoon() {
        return bookedTimeAfternoon;
    }

    public void setBookedTimeAfternoon(Byte bookedTimeAfternoon) {
        this.bookedTimeAfternoon = bookedTimeAfternoon;
    }

    public Byte getBookedTimeNight() {
        return bookedTimeNight;
    }

    public void setBookedTimeNight(Byte bookedTimeNight) {
        this.bookedTimeNight = bookedTimeNight;
    }

    public Timestamp getsOrdTime() {
        return sOrdTime;
    }

    public void setsOrdTime(Timestamp sOrdTime) {
        this.sOrdTime = sOrdTime;
    }

    public Byte getsOrdStat() {
        return sOrdStat;
    }

    public void setsOrdStat(Byte sOrdStat) {
        this.sOrdStat = sOrdStat;
    }

    public BigDecimal getsTtlPrice() {
        return sTtlPrice;
    }

    public void setsTtlPrice(BigDecimal sTtlPrice) {
        this.sTtlPrice = sTtlPrice;
    }

    public BigDecimal getsDepPrice() {
        return sDepPrice;
    }

    public void setsDepPrice(BigDecimal sDepPrice) {
        this.sDepPrice = sDepPrice;
    }

    public String getsByrName() {
        return sByrName;
    }

    public void setsByrName(String sByrName) {
        this.sByrName = sByrName;
    }

    public String getsByrPhone() {
        return sByrPhone;
    }

    public void setsByrPhone(String sByrPhone) {
        this.sByrPhone = sByrPhone;
    }

    public String getsByrEmail() {
        return sByrEmail;
    }

    public void setsByrEmail(String sByrEmail) {
        this.sByrEmail = sByrEmail;
    }

    public Byte getsPayMethod() {
        return sPayMethod;
    }

    public void setsPayMethod(Byte sPayMethod) {
        this.sPayMethod = sPayMethod;
    }

    public Byte getsPayStat() {
        return sPayStat;
    }

    public void setsPayStat(Byte sPayStat) {
        this.sPayStat = sPayStat;
    }

    public Byte getCheckInStat() {
        return checkInStat;
    }

    public void setCheckInStat(Byte checkInStat) {
        this.checkInStat = checkInStat;
    }

    public String getsReturnMark() {
        return sReturnMark;
    }

    public void setsReturnMark(String sReturnMark) {
        this.sReturnMark = sReturnMark;
    }

    public BigDecimal getsCompensation() {
        return sCompensation;
    }

    public void setsCompensation(BigDecimal sCompensation) {
        this.sCompensation = sCompensation;
    }

    public Set<StudioTimeBooking> getStudioTimeBookings() {
        return studioTimeBookings;
    }

    public void setStudioTimeBookings(Set<StudioTimeBooking> studioTimeBookings) {
        this.studioTimeBookings = studioTimeBookings;
    }
}
