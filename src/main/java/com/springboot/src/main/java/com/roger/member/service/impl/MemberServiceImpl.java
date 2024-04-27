package com.roger.member.service.impl;

import com.roger.member.dao.MemberRepository;
import com.roger.member.entity.Member;
import com.roger.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    /**
     * 自動裝配的 MemberRepository，用於執行會員相關的資料庫操作。
     */
    @Autowired
    private MemberRepository memberRepository;

    /**
     * 自動裝配的 StringRedisTemplate，用於執行與 Redis 資料庫操作，特別是針對字串類型的資料。
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Member register(Member member) {
        return null;
    }

    @Override
    public Member login(String memMail, String memPwd) {
        return null;
    }

    @Override
    public Member findByNo(Integer memNo) {
        return null;
    }

    /**
     * 查找所有會員並返回一個 MemberVO 的列表。
     *
     * @return 包含所有會員的 List<MemberVO> 列表。
     */
    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }


}
