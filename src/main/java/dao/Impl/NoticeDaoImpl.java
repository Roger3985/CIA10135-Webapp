package dao.Impl;

import VO.MemberVO;
import VO.NoticeVO;
import dao.NoticeDao_interface;

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
