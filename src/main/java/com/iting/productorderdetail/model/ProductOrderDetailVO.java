package com.iting.productorderdetail.model;

import com.ren.product.model.ProductVO;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ProductOrderDetail")
public class ProductOrderDetailVO {
    @EmbeddedId
    private CompositepOrdNopNo compositepOrdNopNo;
    @ManyToOne
    @JoinColumn(name = "pNo", referencedColumnName = "pNo", insertable = false, updatable = false)
    private ProductVO product;
    @Column(name = "pPrice")
    private BigDecimal pPrice;
    @Column(name = "pOrdQty")
    private Integer pOrdQty;
    @Column(name = "pRealPrice")
    private BigDecimal pRealPrice;
    @Column(name = "pComContent")
    private String pComContent;
    @Column(name = "pScore")
    private Integer pScore;

    public CompositepOrdNopNo getCompositepOrdNopNo() {
        return compositepOrdNopNo;
    }

    public void setCompositepOrdNopNo(CompositepOrdNopNo compositepOrdNopNo) {
        this.compositepOrdNopNo = compositepOrdNopNo;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getpOrdQty() {
        return pOrdQty;
    }

    public void setpOrdQty(Integer pOrdQty) {
        this.pOrdQty = pOrdQty;
    }

    public BigDecimal getpRealPrice() {
        return pRealPrice;
    }

    public void setpRealPrice(BigDecimal pRealPrice) {
        this.pRealPrice = pRealPrice;
    }

    public String getpComContent() {
        return pComContent;
    }

    public void setpComContent(String pComContent) {
        this.pComContent = pComContent;
    }

    public Integer getpScore() {
        return pScore;
    }

    public void setpScore(Integer pScore) {
        this.pScore = pScore;
    }

    @Embeddable
    public static class CompositepOrdNopNo implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "pOrdNo")
        private Integer pOrdNo;
        @Column(name = "pNo")
        private Integer pNo;

        public CompositepOrdNopNo() {
            super();
        }

        public CompositepOrdNopNo(Integer pOrdNo, Integer pNo) {
            super();
            this.pOrdNo = pOrdNo;
            this.pNo = pNo;
        }

        public Integer getpOrdNo() {
            return pOrdNo;
        }

        public void setpOrdNo(Integer pOrdNo) {
            this.pOrdNo = pOrdNo;
        }

        public Integer getpNo() {
            return pNo;
        }

        public void setpNo(Integer pNo) {
            this.pNo = pNo;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((pOrdNo == null) ? 0 : pOrdNo.hashCode());
            result = prime * result + ((pNo == null) ? 0 : pNo.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj != null && getClass() == obj.getClass()) {
                CompositepOrdNopNo compositepOrdNopNo = (CompositepOrdNopNo) obj;
                if (pOrdNo.equals(compositepOrdNopNo.pOrdNo) && pNo.equals(compositepOrdNopNo.pNo)) {
                    return true;
                }
            }
            return false;
        }
    }

}
