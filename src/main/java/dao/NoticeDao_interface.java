package dao;

import VO.MemberVO;
import VO.NoticeVO;

import java.util.List;
import java.util.Set;

public interface NoticeDao_interface {

    public void insert(NoticeVO noticeVO);
    public void update(NoticeVO noticeVO);
    public void delete(Integer notNo);
    public NoticeVO findByPrimaryKey(Integer notNo);
    public List<NoticeVO> getAll();

    //查詢某部門的員工(一對多)(回傳 Set)
    public Set<MemberVO> getEmpsByDeptno(Integer notNo);

}
