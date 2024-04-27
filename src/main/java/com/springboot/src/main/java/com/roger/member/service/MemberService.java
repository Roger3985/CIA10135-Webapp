package com.roger.member.service;

import com.roger.member.entity.Member;
import java.util.List;

public interface MemberService {

    /**
     * 註冊新會員。
     *
     * @param member 新會員的資料，封裝在 MemberVO 物件中。
     * @return 註冊成功後的 MemberVO 物件，其中可能包含更新的會員資訊 (例如:自動生成的會員編號)
     */
    public Member register(Member member);

    /**
     * 登入會員並驗證其帳號和密碼。
     *
     * @param memMail 會員的註冊信箱。
     * @param memPwd 會員的註冊密碼。
     * @return 登入成功後的 MemberVO 物件，其中包含該會員的資料。
     */
    public Member login(String memMail, String memPwd);

    /**
     * 根據會員編號查詢會員資料
     *
     * @param memNo 要查詢的會員編號
     * @return 找到相對應的會員，則返回 MemberVO 物件。
     */
    public Member findByNo(Integer memNo);

    /**
     * 查找所有會員。
     *
     * @return 包含所有會員的 List<Member> 列表。
     */
    public List<Member> findAll();



}
