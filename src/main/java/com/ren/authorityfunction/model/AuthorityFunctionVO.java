package com.ren.authorityfunction.model;

import javax.persistence.*;

@Entity
@Table(name = "AuthorityFunction")
public class AuthorityFunctionVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authFuncNo")
    private Integer authFuncNo;
    @Column(name = "authFuncInfo")
    private String authFuncInfo;

    public Integer getAuthFuncNo() {
        return authFuncNo;
    }

    public void setAuthFuncNo(Integer authFuncNo) {
        this.authFuncNo = authFuncNo;
    }

    public String getAuthFuncInfo() {
        return authFuncInfo;
    }

    public void setAuthFuncInfo(String authFuncInfo) {
        this.authFuncInfo = authFuncInfo;
    }

}
