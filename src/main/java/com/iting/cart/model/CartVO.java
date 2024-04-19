package com.iting.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pNo")
public class CartVO {
    @Id
    @Column(name = "pNo")
    private Integer pNo;
    @Id
    @Column(name = "memNo")
    private Integer memNo;
    @Column(name = "pBuyQty")
    private Integer pBuyQty;

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Integer getpBuyQty() {
        return pBuyQty;
    }

    public void setpBuyQty(Integer pBuyQty) {
        this.pBuyQty = pBuyQty;
    }

}
