package com.roger.columnreply.vo;

import com.roger.columnarticle.vo.ColumnArticleVO;
import com.roger.member.vo.MemberVO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "columnReply")
public class ColumnReplyVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "columnReplyNo")
    private Integer columnReplyNo;

    @ManyToOne
    @JoinColumn(name = "artNo", referencedColumnName = "artNo")
    private ColumnArticleVO columnArticleVO;

//    @Column(name = "artNo")
//    private Integer artNo;

    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO memberVO;

//    @Column(name = "memNo")
//    private Integer memNo;

    @Column(name = "comContent")
    private String comContent;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "comTime")
    private Timestamp comTime;

    @Column(name = "comStat")
    private Byte comStat;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private Set<ColumnReplyVO> reports;

    public Integer getColumnReplyNo() {
        return columnReplyNo;
    }

    public void setColumnReplyNo(Integer columnReplyNo) {
        this.columnReplyNo = columnReplyNo;
    }

    public ColumnArticleVO getColumnArticleVO() {
        return columnArticleVO;
    }

    public void setColumnArticleVO(ColumnArticleVO columnArticleVO) {
        this.columnArticleVO = columnArticleVO;
    }

    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
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

    public Set<ColumnReplyVO> getReports() {
        return reports;
    }

    public void setReports(Set<ColumnReplyVO> reports) {
        this.reports = reports;
    }
}
