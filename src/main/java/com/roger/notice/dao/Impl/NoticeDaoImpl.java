package com.roger.notice.dao.Impl;

import com.roger.notice.VO.MemberVO;
import com.roger.notice.VO.NoticeVO;
import com.roger.notice.dao.NoticeDao_interface;

import java.util.List;
import java.util.Set;

public class NoticeDaoImpl implements NoticeDao_interface {
    @Override
    public void insert(NoticeVO noticeVO) {

    }

    @Override
    public void update(NoticeVO noticeVO) {

    }

    @Override
    public void delete(Integer notNo) {

    }

    @Override
    public NoticeVO findByPrimaryKey(Integer notNo) {
        return null;
    }

    @Override
    public List<NoticeVO> getAll() {
        return null;
    }

    @Override
    public Set<MemberVO> getEmpsByDeptno(Integer notNo) {
        return null;
    }
}
