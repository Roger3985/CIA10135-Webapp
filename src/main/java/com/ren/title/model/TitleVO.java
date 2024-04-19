package com.ren.title.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Title")
public class TitleVO {
    @Id
    @Column(name = "titleNo")
    private Integer titleNo;
    @Column(name = "titleName")
    private String titleName;

    public Integer getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(Integer titleNo) {
        this.titleNo = titleNo;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

}
