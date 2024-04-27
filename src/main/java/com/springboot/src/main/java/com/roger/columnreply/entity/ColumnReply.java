package com.roger.columnreply.entity;

import com.roger.columnarticle.entity.ColumnArticle;
import com.roger.member.entity.Member;
import com.roger.report.entity.Report;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "columnReply")
public class ColumnReply implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "columnReplyNo")
    private Integer columnReplyNo;
    @ManyToOne
    @JoinColumn(name = "artNo", referencedColumnName = "artNo")
    private ColumnArticle columnArticle;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private Member member;
    @Column(name = "comContent")
    private String comContent;
    @Column(name = "comTime")
    private Timestamp comTime;
    @Column(name = "comStat")
    private Byte comStat;
    @OneToMany(mappedBy = "columnReply", cascade = CascadeType.ALL)
    private Set<Report> reports;

    public Integer getColumnReplyNo() {
        return columnReplyNo;
    }

    public void setColumnReplyNo(Integer columnReplyNo) {
        this.columnReplyNo = columnReplyNo;
    }

    public ColumnArticle getColumnArticle() {
        return columnArticle;
    }

    public void setColumnArticle(ColumnArticle columnArticle) {
        this.columnArticle = columnArticle;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getComTime() {
        return comTime;
    }

    public void setComTime(Timestamp comTime) {
        this.comTime = comTime;
    }

    public Byte getComStat() {
        return comStat;
    }

    public void setComStat(Byte comStat) {
        this.comStat = comStat;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }
}
