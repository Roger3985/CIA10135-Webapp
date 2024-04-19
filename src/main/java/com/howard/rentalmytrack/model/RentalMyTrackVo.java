package com.howard.rentalmytrack.model;

import java.sql.Date;
import java.sql.Timestamp;

public class RentalMyTrackVo {

	/*
	 * rNo -> 租借品編號
	 * memNo -> 會員編號
	 * rTrackTime -> 加入追蹤時間
	 * expRentalDate -> 期望租借時間
	 */
	
    private Integer rNo;
    private Integer memNo;
    private Timestamp rTrackTime;
    private Date expRentalDate;


/*----------------------getter、setter--------------------------*/
    
	public Integer getrNo() {
		return rNo;
	}
	public void setrNo(Integer rNo) {
		this.rNo = rNo;
	}
	public Integer getmemNo() {
		return memNo;
	}
	public void setmemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public Timestamp getrTrackTime() {
		return rTrackTime;
	}
	public void setrTrackTime(Timestamp rTrackTime) {
		this.rTrackTime = rTrackTime;
	}
	public Date getexpRentalDate() {
		return expRentalDate;
	}
	public void setexpRentalDate(Date expRentalDate) {
		this.expRentalDate = expRentalDate;
	}

}
