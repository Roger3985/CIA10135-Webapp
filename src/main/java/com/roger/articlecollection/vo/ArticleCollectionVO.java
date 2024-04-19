package com.roger.articlecollection.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articlecollection")
public class ArticleCollectionVO implements java.io.Serializable {

    @Id
    @Column(name = "memNo")
    private Integer memNo;

    private Integer artNo;

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
}
