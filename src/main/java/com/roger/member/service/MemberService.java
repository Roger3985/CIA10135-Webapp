package com.roger.member.service;

import com.roger.member.dao.MemberDao_interface;
import com.roger.member.dao.impl.MemberJdbcDaoImpl;
import com.roger.member.vo.MemberVO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class MemberService {

    private MemberDao_interface dao;

    public MemberService() {
        dao = new MemberJdbcDaoImpl();
    }

    public MemberVO addMem(String mName, String memAcc, String memPwd, String memMob
            , Byte mGender, String memMail, String memAdd, Date memBd
            , String memCard, Byte provider, String clientID, String displayName
            , String accessToken, String refreshToken, Timestamp tknExpireTime
            , Timestamp creationTime, Timestamp memberJoinTime, Byte memStat) {

        MemberVO memberVO = new MemberVO();

        memberVO.setmName(mName);
        memberVO.setMemAcc(memAcc);
        memberVO.setMemPwd(memPwd);
        memberVO.setMemMob(memMob);
        memberVO.setmGender(mGender);
        memberVO.setMemMail(memMail);
        memberVO.setMemAdd(memAdd);
        memberVO.setMemBd(memBd);
        memberVO.setMemCard(memCard);
        memberVO.setProvider(provider);
        memberVO.setClientID(clientID);
        memberVO.setDisplayName(displayName);
        memberVO.setAccessToken(accessToken);
        memberVO.setRefreshToken(refreshToken);
        memberVO.setTknExpireTime(tknExpireTime);
        memberVO.setCreationTime(creationTime);
        memberVO.setMemberJoinTime(memberJoinTime);
        memberVO.setMemStat(memStat);

        dao.insert(memberVO);
        return memberVO;
    }

    public MemberVO updateMem(Integer memNo, String mName, String memAcc, String memPwd, String memMob
            , Byte mGender, String memMail, String memAdd, Date memBd
            , String memCard, Byte provider, String clientID, String displayName
            , String accessToken, String refreshToken, Timestamp tknExpireTime
            , Timestamp creationTime, Timestamp memberJoinTime, Byte memStat) {

        MemberVO memberVO = new MemberVO();

        memberVO.setMemNo(memNo);
        memberVO.setmName(mName);
        memberVO.setMemAcc(memAcc);
        memberVO.setMemPwd(memPwd);
        memberVO.setMemMob(memMob);
        memberVO.setmGender(mGender);
        memberVO.setMemMail(memMail);
        memberVO.setMemAdd(memAdd);
        memberVO.setMemBd(memBd);
        memberVO.setMemCard(memCard);
        memberVO.setProvider(provider);
        memberVO.setClientID(clientID);
        memberVO.setDisplayName(displayName);
        memberVO.setAccessToken(accessToken);
        memberVO.setRefreshToken(refreshToken);
        memberVO.setTknExpireTime(tknExpireTime);
        memberVO.setCreationTime(creationTime);
        memberVO.setMemberJoinTime(memberJoinTime);
        memberVO.setMemStat(memStat);
        dao.update(memberVO);

        return dao.findByPrimaryKey(memNo);
    }

    public void deleteMem(Integer memNo) {
        dao.delete(memNo);
    }

    public MemberVO getOneMem(Integer memNo) {
        return dao.findByPrimaryKey(memNo);
    }

    public MemberVO getOneMemName(String mName) {
        return dao.findByName(mName);
    }

    public List<MemberVO> getAll() {
        return dao.getAll();
    }
}
