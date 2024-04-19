package com.ren.administrator.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Administrator")
public class AdministratorVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admNo")
    private Integer admNo;
    @Column(name = "admPwd")
    private String admPwd;
    @Column(name = "admName")
    private String admName;
    @Column(name = "admStat")
    private Byte admStat;
    @Column(name = "admEmail")
    private String admEmail;
    @Column(name = "titleNo")
    private Integer titleNo;
    @Column(name = "admHireDate")
    private Date admHireDate;
    @Column(name = "admPhoto")
    private byte[] admPhoto;

    public Integer getAdmNo() {
        return admNo;
    }

    public void setAdmNo(Integer admNo) {
        this.admNo = admNo;
    }

    public String getAdmPwd() {
        return admPwd;
    }

    public void setAdmPwd(String admPwd) {
        this.admPwd = admPwd;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public Byte getAdmStat() {
        return admStat;
    }

    public void setAdmStat(Byte admStat) {
        this.admStat = admStat;
    }

    public String getAdmEmail() {
        return admEmail;
    }

    public void setAdmEmail(String admEmail) {
        this.admEmail = admEmail;
    }

    public Integer getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(Integer titleNo) {
        this.titleNo = titleNo;
    }

    public Date getAdmHireDate() {
        return admHireDate;
    }

    public void setAdmHireDate(Date admHireDate) {
        this.admHireDate = admHireDate;
    }

    public byte[] getAdmPhoto() {
        return admPhoto;
    }

    public void setAdmPhoto(byte[] admPhoto) {
        this.admPhoto = admPhoto;
    }
}
