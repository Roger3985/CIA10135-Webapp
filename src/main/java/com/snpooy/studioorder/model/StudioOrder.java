package com.snpooy.studioorder.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class StudioOrder {
	private Integer sOrdNo;
	private Integer memNo;
	private Integer sNo;
	private Integer admNo;
	private Date bookedDate;
	private Boolean bookedTimeMorning;
	private Boolean bookedTimeAfternoon;
	private Boolean bookedTimeNight;
	private Timestamp sOrdTime;
	private Byte sOrdStat;
	private BigDecimal sTtlPrice;
	private String sByrName;
	private BigDecimal sDepPrice;
	private String sByrPhone;
	private String sByrEmail;
	private Byte sPayMethod;
	private Byte sPayStat;
	private Boolean checkInStat;
	private String sReturnMark;
	private BigDecimal sCompensation;

	public Integer getsOrdNo() {
		return sOrdNo;
	}

	public void setsOrdNo(Integer sOrdNo) {
		this.sOrdNo = sOrdNo;
	}

	public Integer getMemNo() {
		return memNo;
	}

	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public Integer getAdmNo() {
		return admNo;
	}

	public void setAdmNo(Integer admNo) {
		this.admNo = admNo;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Boolean getBookedTimeMorning() {
		return bookedTimeMorning;
	}

	public void setBookedTimeMorning(Boolean bookedTimeMorning) {
		this.bookedTimeMorning = bookedTimeMorning;
	}

	public Boolean getBookedTimeAfternoon() {
		return bookedTimeAfternoon;
	}

	public void setBookedTimeAfternoon(Boolean bookedTimeAfternoon) {
		this.bookedTimeAfternoon = bookedTimeAfternoon;
	}

	public Boolean getBookedTimeNight() {
		return bookedTimeNight;
	}

	public void setBookedTimeNight(Boolean bookedTimeNight) {
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

	public String getsByrName() {
		return sByrName;
	}

	public void setsByrName(String sByrName) {
		this.sByrName = sByrName;
	}

	public BigDecimal getsDepPrice() {
		return sDepPrice;
	}

	public void setsDepPrice(BigDecimal sDepPrice) {
		this.sDepPrice = sDepPrice;
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

	public Boolean getCheckInStat() {
		return checkInStat;
	}

	public void setCheckInStat(Boolean checkInStat) {
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
}
