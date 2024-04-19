package com.iting.productmyfavorite.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductMyFavorite")
public class ProductMyFavoriteVO {
    @EmbeddedId
    private CompositeProductMyFavorite compositeProductMyFavorite;

    public CompositeProductMyFavorite getCompositeProductMyFavorite() {
        return compositeProductMyFavorite;
    }

    public void setCompositeProductMyFavorite(CompositeProductMyFavorite compositeProductMyFavorite) {
        this.compositeProductMyFavorite = compositeProductMyFavorite;
    }

    @Embeddable
    public static class CompositeProductMyFavorite implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "pNo")
        private Integer pNo;
        @Column(name = "memNo")
        private Integer memNo;

        public CompositeProductMyFavorite() {
            super();
        }

        public CompositeProductMyFavorite(Integer pNo, Integer memNo) {
            super();
            this.pNo = pNo;
            this.memNo = memNo;
        }

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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((pNo == null) ? 0 : pNo.hashCode());
            result = prime * result + ((memNo == null) ? 0 : memNo.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj != null && getClass() == obj.getClass()) {
                CompositeProductMyFavorite compositeProductMyFavorite = (CompositeProductMyFavorite) obj;
                if (pNo.equals(compositeProductMyFavorite.pNo) && memNo.equals(compositeProductMyFavorite.memNo)) {
                    return true;
                }
            }
            return false;
        }
    }

}
