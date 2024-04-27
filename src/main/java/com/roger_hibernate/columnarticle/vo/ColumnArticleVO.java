package com.roger_hibernate.columnarticle.vo;

import com.ren.administrator.model.AdministratorVO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "columnarticle")
public class ColumnArticleVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artNo")
    private Integer artNo;

    @ManyToOne
    @JoinColumn(name = "admNo", referencedColumnName = "admNo")
    private AdministratorVO administratorVO;

//    @Column(name = "admNo")
//    private Integer admNo;

    @Column(name = "artTitle")
    private String artTitle;

    @Column(name = "artContent")
    private String artContent;

    @Column(name = "artTime")
    private Timestamp artTime;

    @Column(name = "artCatNo")
    private Integer artCatNo;

    @Column(name = "artStat")
    private Byte artStat;

    @OneToMany(mappedBy = "clickLike", cascade = CascadeType.ALL)
    private Set<ColumnArticleVO> clickLikes;

    @OneToMany(mappedBy = "articleCollection", cascade = CascadeType.ALL)
    private Set<ColumnArticleVO> articleCollections;

    @OneToMany(mappedBy = "columnReply", cascade = CascadeType.ALL)
    private Set<ColumnArticleVO> columnReplys;


    public Integer getArtNo() {
        return artNo;
    }

    public void setArtNo(Integer artNo) {
        this.artNo = artNo;
    }

    public AdministratorVO getAdministratorVO() {
        return administratorVO;
    }

    public void setAdministratorVO(AdministratorVO administratorVO) {
        this.administratorVO = administratorVO;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public Timestamp getArtTime() {
        return artTime;
    }

    public void setArtTime(Timestamp artTime) {
        this.artTime = artTime;
    }

    public Integer getArtCatNo() {
        return artCatNo;
    }

    public void setArtCatNo(Integer artCatNo) {
        this.artCatNo = artCatNo;
    }

    public Byte getArtStat() {
        return artStat;
    }

    public void setArtStat(Byte artStat) {
        this.artStat = artStat;
    }

    public Set<ColumnArticleVO> getClickLikes() {
        return clickLikes;
    }

    public void setClickLikes(Set<ColumnArticleVO> clickLikes) {
        this.clickLikes = clickLikes;
    }

    public Set<ColumnArticleVO> getArticleCollections() {
        return articleCollections;
    }

    public void setArticleCollections(Set<ColumnArticleVO> articleCollections) {
        this.articleCollections = articleCollections;
    }

    public Set<ColumnArticleVO> getColumnReplys() {
        return columnReplys;
    }

    public void setColumnReplys(Set<ColumnArticleVO> columnReplys) {
        this.columnReplys = columnReplys;
    }
}
