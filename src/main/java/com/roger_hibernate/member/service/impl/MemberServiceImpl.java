package com.roger_hibernate.member.service.impl;

import com.roger_hibernate.member.dao.MemberDao_interface;
import com.roger_hibernate.member.dao.impl.MemberHibernateDaoImpl;
import com.roger_hibernate.member.service.MemberService;
import com.roger_hibernate.member.vo.MemberVO;

import java.util.List;
import java.util.Map;

import static com.roger_hibernate.util.Constants.PAGE_MAX_RESULT;

// 搭配 JSP / Thymeleaf 後端渲染畫面，將交易動作至於 view filter
public class MemberServiceImpl implements MemberService {
    // 一個 service 實體對應一個 dao 實體
    private MemberDao_interface dao;

    public MemberServiceImpl() {
        dao = new MemberHibernateDaoImpl();
    }

    @Override
    public MemberVO addMem(MemberVO memberVO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemberVO updateMem(MemberVO memberVO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteMem(Integer memNo) {
        // TODO Auto-generated method stub
    }

    @Override
    public MemberVO getOneMem(Integer memNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemberVO getOneMemName(String mName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemberVO getOneMemAccount(String account) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MemberVO> getAll(int currentPage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isExistingMemberAccount(String memAcc) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isExistingMemberMobile(String memMob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isExistingMemberMail(String memMail) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getPageTotal() {
        long total = dao.getTotal();
        // 計算Member數量每頁5筆的話總共有幾頁
        int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
        return pageQty;
    }

    @Override
    public List<MemberVO> getMembersByCompositeQuery(Map<String, String[]> map) {

        return null;
    }
}
