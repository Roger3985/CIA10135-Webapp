package com.roger.notice.vo;

import com.roger.member.vo.MemberVO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notice")
public class NoticeVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motNo")
    private Integer motNo;

    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO memberVO; // 定義多對一關係(現在表示:通知\(多)，會員(單))，該字段關聯到 MemberVO 實體類，使用 memNo 列作為外來鍵。 需要再生成getter and setter

    // JDBC、JNDI使用(Hibernate換成ManyToOne)
//    @Column(name = "memNo")
//    private Integer memNo; // 定義 memNo 列，作為當前實體類與 MemberVO 實體類之間的外來鍵。

    @Column(name = "notContent")
    private String notContent;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "notTime")
    private Timestamp notTime;

    @Column(name = "notStat")
    private Byte notStat;

    public Integer getMotNo() {
        return motNo;
    }

    public void setMotNo(Integer motNo) {
        this.motNo = motNo;
    }

    /*
    * 定義多對一關係，該字段關聯到 MemberVO 實體類，使用 memNo 列作為外來鍵。
    * 需要再生成getter and setter
    * */
    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public String getNotContent() {
        return notContent;
    }

    public void setNotContent(String notContent) {
        this.notContent = notContent;
    }

    public Timestamp getNotTime() {
        return notTime;
    }

    public void setNotTime(Timestamp notTime) {
        this.notTime = notTime;
    }

    public Byte getNotStat() {
        return notStat;
    }

    public void setNotStat(Byte notStat) {
        this.notStat = notStat;
    }
}
