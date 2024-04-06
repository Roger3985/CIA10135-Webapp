package com.roger.notice.dao.impl;

import com.roger.notice.dao.NoticeDao_interface;
import com.roger.notice.vo.MemberVO;
import com.roger.notice.vo.NoticeVO;

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
