package com.roger.report.vo;

import com.ren.administrator.model.AdministratorVO;
import com.roger.columnreply.vo.ColumnReplyVO;
import com.roger.member.vo.MemberVO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "report")
public class ReportVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportNo")
    private Integer reportNo;

    @ManyToOne
    @JoinColumn(name = "artReplyNo", referencedColumnName = "columnReplyNo")
    private ColumnReplyVO columnReplyVo;

    // private Integer artReplyNo;

    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO memberVO;

    // private Integer memNo;

    @ManyToOne
    @JoinColumn(name = "admNo", referencedColumnName = "admNo")
    private AdministratorVO administratorVO;

    // private Integer admNo;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reportTime")
    private Timestamp reportTime;

    @Column(name = "reportReason")
    private String reportReason;

    @Column(name = "reportType")
    private Byte reportType;

    public Integer getReportNo() {
        return reportNo;
    }

    public void setReportNo(Integer reportNo) {
        this.reportNo = reportNo;
    }

    public ColumnReplyVO getColumnReplyVo() {
        return columnReplyVo;
    }

    public void setColumnReplyVo(ColumnReplyVO columnReplyVo) {
        this.columnReplyVo = columnReplyVo;
    }

    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public AdministratorVO getAdministratorVO() {
        return administratorVO;
    }

    public void setAdministratorVO(AdministratorVO administratorVO) {
        this.administratorVO = administratorVO;
    }

    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public Byte getReportType() {
        return reportType;
    }

    public void setReportType(Byte reportType) {
        this.reportType = reportType;
    }
}
