package com.roger.columnarticle.entity;

import com.ren.administrator.entity.Administrator;
import com.roger.articlecollection.entity.ArticleCollection;
import com.roger.clicklike.entity.ClickLike;
import com.roger.columnreply.entity.ColumnReply;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "columnarticle")
public class ColumnArticle implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artNo")
    private Integer artNo;

    @ManyToOne
    @JoinColumn(name = "admNo", referencedColumnName = "admNo")
    private Administrator administrator;

//    @Column(name = "admNo")
//    private Integer admNo;

    @Column(name = "artTitle")
    private String artTitle;

    @Column(name = "artContent", columnDefinition = "longtext")
    private String artContent;

    @Column(name = "artTime")
    private Timestamp artTime;

    @Column(name = "artCatNo")
    private Integer artCatNo;

    @Column(name = "artStat")
    private Byte artStat;

    @OneToMany(mappedBy = "columnArticle", cascade = CascadeType.ALL)
    private Set<ClickLike> clickLikes;

    @OneToMany(mappedBy = "columnArticle", cascade = CascadeType.ALL)
    private Set<ArticleCollection> articleCollections;

    @OneToMany(mappedBy = "columnArticle", cascade = CascadeType.ALL)
    private Set<ColumnReply> columnReplies;

    public Integer getArtNo() {
        return artNo;
    }

    public void setArtNo(Integer artNo) {
        this.artNo = artNo;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
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

    public Set<ClickLike> getClickLikes() {
        return clickLikes;
    }

    public void setClickLikes(Set<ClickLike> clickLikes) {
        this.clickLikes = clickLikes;
    }

    public Set<ArticleCollection> getArticleCollections() {
        return articleCollections;
    }

    public void setArticleCollections(Set<ArticleCollection> articleCollections) {
        this.articleCollections = articleCollections;
    }

    public Set<ColumnReply> getColumnReplies() {
        return columnReplies;
    }

    public void setColumnReplies(Set<ColumnReply> columnReplies) {
        this.columnReplies = columnReplies;
    }
}
