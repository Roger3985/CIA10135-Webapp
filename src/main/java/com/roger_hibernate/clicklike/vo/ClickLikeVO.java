package com.roger_hibernate.clicklike.vo;

import com.roger_hibernate.columnarticle.vo.ColumnArticleVO;
import com.roger_hibernate.member.vo.MemberVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "clickLike")
public class ClickLikeVO implements java.io.Serializable {

    @EmbeddedId
    private CompositeClickLike compositeClickLike;

    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO memberVO;

    // private Integer memNo;

    @ManyToOne
    @JoinColumn(name = "artNo", referencedColumnName = "artNo")
    private ColumnArticleVO columnArticleVO;

    // private Integer artNo;


    public CompositeClickLike getCompositeClickLike() {
        return compositeClickLike;
    }

    public void setCompositeClickLike(CompositeClickLike compositeClickLike) {
        this.compositeClickLike = compositeClickLike;
    }

    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public ColumnArticleVO getColumnArticleVO() {
        return columnArticleVO;
    }

    public void setColumnArticleVO(ColumnArticleVO columnArticleVO) {
        this.columnArticleVO = columnArticleVO;
    }

    @Embeddable
    public static class CompositeClickLike implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "memNo")
        private Integer memNo;

        @Column(name = "artNo")
        private Integer artNo;

        public CompositeClickLike() {
        }

        public CompositeClickLike(Integer memNo, Integer artNo) {
            this.memNo = memNo;
            this.artNo = artNo;
        }

        public Integer getMemNo() {
            return memNo;
        }

        public void setMemNo(Integer memNo) {
            this.memNo = memNo;
        }

        public Integer getArtNo() {
            return artNo;
        }

        public void setArtNo(Integer artNo) {
            this.artNo = artNo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompositeClickLike that)) return false;
            return Objects.equals(getMemNo(), that.getMemNo()) && Objects.equals(getArtNo(), that.getArtNo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMemNo(), getArtNo());
        }
    }

}
