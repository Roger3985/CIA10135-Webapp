package com.chihyun.coupon.entity;

import com.chihyun.mycoupon.entity.MyCoupon;
import com.iting.productorder.entity.ProductOrder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Coupon")
public class Coupon {
    @Id
    @Column(name = "coupNo")
    private Integer coupNo;
    @Column(name = "coupName")
    private String coupName;
    @Column(name = "coupCond")
    private String coupCond;
    @Column(name = "coupDisc")
    private BigDecimal coupDisc;
    @Column(name = "coupAddDate")
    private Timestamp coupAddDate;
    @Column(name = "coupExpDate")
    private Timestamp coupExpDate;
    @Column(name = "coupRelDate")
    private Timestamp coupRelDate;
    @Column(name = "coupRelStat")
    private Byte coupRelStat;
    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL)
    private Set<ProductOrder> productOrders;
    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL)
    private Set<MyCoupon> myCoupons;

    public Integer getCoupNo() {
        return coupNo;
    }

    public void setCoupNo(Integer coupNo) {
        this.coupNo = coupNo;
    }

    public String getCoupName() {
        return coupName;
    }

    public void setCoupName(String coupName) {
        this.coupName = coupName;
    }

    public String getCoupCond() {
        return coupCond;
    }

    public void setCoupCond(String coupCond) {
        this.coupCond = coupCond;
    }

    public BigDecimal getCoupDisc() {
        return coupDisc;
    }

    public void setCoupDisc(BigDecimal coupDisc) {
        this.coupDisc = coupDisc;
    }

    public Timestamp getCoupAddDate() {
        return coupAddDate;
    }

    public void setCoupAddDate(Timestamp coupAddDate) {
        this.coupAddDate = coupAddDate;
    }

    public Timestamp getCoupExpDate() {
        return coupExpDate;
    }

    public void setCoupExpDate(Timestamp coupExpDate) {
        this.coupExpDate = coupExpDate;
    }

    public Timestamp getCoupRelDate() {
        return coupRelDate;
    }

    public void setCoupRelDate(Timestamp coupRelDate) {
        this.coupRelDate = coupRelDate;
    }

    public Byte getCoupRelStat() {
        return coupRelStat;
    }

    public void setCoupRelStat(Byte coupRelStat) {
        this.coupRelStat = coupRelStat;
    }

    public Set<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(Set<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public Set<MyCoupon> getMyCoupons() {
        return myCoupons;
    }

    public void setMyCoupons(Set<MyCoupon> myCoupons) {
        this.myCoupons = myCoupons;
    }
}
