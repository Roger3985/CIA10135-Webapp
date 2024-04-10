package com.roger.member.dao;

import com.roger.member.vo.MemberVO;

import java.util.List;

public interface MemberDao_interface {

    // 新增會員資料
    public void insert(MemberVO memberVO);

    // 更新會員資料
    public void update(MemberVO memberVO);

    // 刪除會員資料
    public void delete(Integer memNo);

    // 查詢一個會員資料
    public MemberVO findByPrimaryKey(Integer memNo);

    // 利用姓名查詢會員資料
    public MemberVO findByName(String mName);

    // 利用會員帳號查詢會員資料
    public MemberVO findByAccount(String memAcc);

    // 查詢全部會員的註冊資料
    public List<MemberVO> getAll();

    // 查詢是否有重複的會員帳號
    public boolean isExistingMemberAccount(String memAcc);

    // 查詢是否有重複的電話號碼
    public boolean isExistingMemberMobile(String memMob);

    // 查詢是否有重複的電子信箱
    public boolean isExistingMemberMail(String memMail);

}
