package com.howard.rentalorderdetails.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "rentalorderdetails")
@IdClass(RentalOrderDetails.CompositeDetail.class)
public class RentalOrderDetails {

    /*
     * rOrdNo -> 租借品訂單編號
     * rNo -> 租借品編號
     * rPrice -> 單價
     * rDesPrice -> 押金(單件)
     */

    @Id
    @Column(name = "rOrdNo")
    private Integer rOrdNo;
    @Id
    @Column(name = "rNo")
    private Integer rNo;
    @Column(name = "rPrice")
    private BigDecimal rPrice;
    @Column(name = "rDesPrice")
    private BigDecimal rDesPrice;


/*----------------------getter、setter--------------------------*/

    public Integer getrOrdNo() {
        return rOrdNo;
    }

    public void setrOrdNo(Integer rOrdNo) {
        this.rOrdNo = rOrdNo;
    }

    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    public BigDecimal getrDesPrice() {
        return rDesPrice;
    }

    public void setrDesPrice(BigDecimal rDesPrice) {
        this.rDesPrice = rDesPrice;
    }


    /*========複合主鍵用的class==========*/
    static class CompositeDetail implements Serializable {

        private Integer rOrdNo;
        private Integer rNo;

        public CompositeDetail() {

        }

        public CompositeDetail(Integer rOrdNo, Integer rNo) {
            this.rOrdNo = rOrdNo;
            this.rNo = rNo;
        }

        public Integer getrOrdNo() {
            return rOrdNo;
        }

        public void setrOrdNo(Integer rOrdNo) {
            this.rOrdNo = rOrdNo;
        }

        public Integer getrNo() {
            return rNo;
        }

        public void setrNo(Integer rNo) {
            this.rNo = rNo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompositeDetail that)) return false;
            return Objects.equals(getrOrdNo(), that.getrOrdNo()) && Objects.equals(getrNo(), that.getrNo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getrOrdNo(), getrNo());
        }
    }
    /*===========複合主鍵用的class結束==========*/

}


