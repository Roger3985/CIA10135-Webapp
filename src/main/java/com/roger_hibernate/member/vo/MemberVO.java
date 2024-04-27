package com.roger_hibernate.member.vo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity // 這個注釋標記 Member 類為一個 JPA 實體（entity）。這意味著這個類將映射到數據庫中的一個表，並表示該類的每個對象（實例）對應於數據庫表中的一行。使用此注釋可以讓 JPA 框架自動管理該類的持久化、查詢、更新和刪除操作。
@Table(name = "member")
public class MemberVO implements java.io.Serializable {

    @Id // 主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 設置自動增長鍵
    @Column(name = "memNo") // 映射到資料庫中的column的memNo
    private Integer memNo;

    @Column(name = "mName")
    private String mName;

    @Column(name = "memAcc", unique = true) //`unique` 屬性設置為 `true`，表示該列應該具有唯一性約束。這意味著數據庫中的每一個 `memAcc` 值都必須是唯一的，不能有重複的值。
    private String memAcc;

    @Column(name = "memPwd")
    private String memPwd;

    @Column(name = "memMob", unique = true)
    private String memMob;

    @Column(name = "mGender")
    private Byte mGender;

    @Column(name = "memMail", unique = true)
    private String memMail;

    @Column(name = "memAdd")
    private String memAdd;

    @Column(name = "memBd")
    private Date memBd;

    @Column(name = "memCard")
    private String memCard;

    @Column(name = "provider")
    private Byte provider;

    @Column(name = "clientID")
    private String clientID;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "accessToken")
    private String accessToken;

    @Column(name = "refreshToken")
    private String refreshToken;

    @Column(name = "tknExpireTime")
    private Timestamp tknExpireTime;

    @Column(name = "creationTime")
    private Timestamp creationTime;

    @CreationTimestamp // 使用 @CreationTimestamp 注釋，這個注釋表示當這個實體對象被持久化時（即被保存到數據庫中），`memberJoinTime` 字段會自動填入當前的日期和時間。
    @Temporal(TemporalType.TIMESTAMP) // 使用 @Temporal 注釋，這個注釋指定了 `memberJoinTime` 字段的時間類型為 `TemporalType.TIMESTAMP`。這表示該字段將存儲包括日期和時間在內的完整時間戳。
    @Column(name = "memberJoinTime")
    private Timestamp memberJoinTime;

    @Column(name = "memStat")
    private Byte memStat;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
    private Set<MemberVO> notices;

    @OneToMany(mappedBy = "mycoupon", cascade = CascadeType.ALL)
    private Set<MemberVO> mycoupons;

    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL)
    private Set<MemberVO> productOrders;

    @OneToMany(mappedBy = "productMyFavorite", cascade = CascadeType.ALL)
    private Set<MemberVO> productMyFavorites;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<MemberVO> carts;

    @OneToMany(mappedBy = "clickLike", cascade = CascadeType.ALL)
    private Set<MemberVO> clickLikes;

    @OneToMany(mappedBy = "articleCollection", cascade = CascadeType.ALL)
    private Set<MemberVO> articleCollections;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private Set<MemberVO> reports;

    @OneToMany(mappedBy = "columnReply", cascade = CascadeType.ALL)
    private Set<MemberVO> columnReplys;

    @OneToMany(mappedBy = "rentalOrder", cascade = CascadeType.ALL)
    private Set<MemberVO> rentalOrders;

    @OneToMany(mappedBy = "rentalMyTrack", cascade = CascadeType.ALL)
    private Set<MemberVO> rentalMyTracks;

    @OneToMany(mappedBy = "rentalMyFavorite", cascade = CascadeType.ALL)
    private Set<MemberVO> rentalMyFavorites;

    @OneToMany(mappedBy = "studioOrder", cascade = CascadeType.ALL)
    private Set<MemberVO> studioOrders;

    @OneToMany(mappedBy = "serviceRecord", cascade = CascadeType.ALL)
    private Set<MemberVO> serviceRecords;

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getMemAcc() {
        return memAcc;
    }

    public void setMemAcc(String memAcc) {
        this.memAcc = memAcc;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public String getMemMob() {
        return memMob;
    }

    public void setMemMob(String memMob) {
        this.memMob = memMob;
    }

    public Byte getmGender() {
        return mGender;
    }

    public void setmGender(Byte mGender) {
        this.mGender = mGender;
    }

    public String getMemMail() {
        return memMail;
    }

    public void setMemMail(String memMail) {
        this.memMail = memMail;
    }

    public String getMemAdd() {
        return memAdd;
    }

    public void setMemAdd(String memAdd) {
        this.memAdd = memAdd;
    }

    public Date getMemBd() {
        return memBd;
    }

    public void setMemBd(Date memBd) {
        this.memBd = memBd;
    }

    public String getMemCard() {
        return memCard;
    }

    public void setMemCard(String memCard) {
        this.memCard = memCard;
    }

    public Byte getProvider() {
        return provider;
    }

    public void setProvider(Byte provider) {
        this.provider = provider;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Timestamp getTknExpireTime() {
        return tknExpireTime;
    }

    public void setTknExpireTime(Timestamp tknExpireTime) {
        this.tknExpireTime = tknExpireTime;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getMemberJoinTime() {
        return memberJoinTime;
    }

    public void setMemberJoinTime(Timestamp memberJoinTime) {
        this.memberJoinTime = memberJoinTime;
    }

    public Byte getMemStat() {
        return memStat;
    }

    public void setMemStat(Byte memStat) {
        this.memStat = memStat;
    }

    public Set<MemberVO> getNotices() {
        return notices;
    }

    public void setNotices(Set<MemberVO> notices) {
        this.notices = notices;
    }

    public Set<MemberVO> getMycoupons() {
        return mycoupons;
    }

    public void setMycoupons(Set<MemberVO> mycoupons) {
        this.mycoupons = mycoupons;
    }

    public Set<MemberVO> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(Set<MemberVO> productOrders) {
        this.productOrders = productOrders;
    }

    public Set<MemberVO> getProductMyFavorites() {
        return productMyFavorites;
    }

    public void setProductMyFavorites(Set<MemberVO> productMyFavorites) {
        this.productMyFavorites = productMyFavorites;
    }

    public Set<MemberVO> getCarts() {
        return carts;
    }

    public void setCarts(Set<MemberVO> carts) {
        this.carts = carts;
    }

    public Set<MemberVO> getClickLikes() {
        return clickLikes;
    }

    public void setClickLikes(Set<MemberVO> clickLikes) {
        this.clickLikes = clickLikes;
    }

    public Set<MemberVO> getArticleCollections() {
        return articleCollections;
    }

    public void setArticleCollections(Set<MemberVO> articleCollections) {
        this.articleCollections = articleCollections;
    }

    public Set<MemberVO> getReports() {
        return reports;
    }

    public void setReports(Set<MemberVO> reports) {
        this.reports = reports;
    }

    public Set<MemberVO> getColumnReplys() {
        return columnReplys;
    }

    public void setColumnReplys(Set<MemberVO> columnReplys) {
        this.columnReplys = columnReplys;
    }

    public Set<MemberVO> getRentalOrders() {
        return rentalOrders;
    }

    public void setRentalOrders(Set<MemberVO> rentalOrders) {
        this.rentalOrders = rentalOrders;
    }

    public Set<MemberVO> getRentalMyTracks() {
        return rentalMyTracks;
    }

    public void setRentalMyTracks(Set<MemberVO> rentalMyTracks) {
        this.rentalMyTracks = rentalMyTracks;
    }

    public Set<MemberVO> getRentalMyFavorites() {
        return rentalMyFavorites;
    }

    public void setRentalMyFavorites(Set<MemberVO> rentalMyFavorites) {
        this.rentalMyFavorites = rentalMyFavorites;
    }

    public Set<MemberVO> getStudioOrders() {
        return studioOrders;
    }

    public void setStudioOrders(Set<MemberVO> studioOrders) {
        this.studioOrders = studioOrders;
    }

    public Set<MemberVO> getServiceRecords() {
        return serviceRecords;
    }

    public void setServiceRecords(Set<MemberVO> serviceRecords) {
        this.serviceRecords = serviceRecords;
    }
}