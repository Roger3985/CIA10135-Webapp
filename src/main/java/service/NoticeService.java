package service;

import VO.NoticeVO;
import dao.Impl.NoticeJdbcDaoImpl;
import dao.NoticeDao_interface;

import java.sql.Timestamp;
import java.util.List;

public class NoticeService {

    private NoticeDao_interface dao;

    public NoticeService() {
        dao = new NoticeJdbcDaoImpl();
    }

    public NoticeVO addNO(Integer memNo, String notContent, Timestamp notTime, Byte notStat) {
        
        NoticeVO noticeVO = new NoticeVO();

        noticeVO.setMemNo(memNo);
        noticeVO.setNotContent(notContent);
        noticeVO.setNotTime(notTime);
        noticeVO.setNotStat(notStat);

        dao.insert(noticeVO);
        return noticeVO;
    }

    public NoticeVO updateNO(Integer notNo, Integer memNo, String notContent, Timestamp notTime, Byte notStat) {

        NoticeVO noticeVO = new NoticeVO();

        noticeVO.setNotNo(notNo);
        noticeVO.setMemNo(memNo);
        noticeVO.setNotContent(notContent);
        noticeVO.setNotTime(notTime);
        noticeVO.setNotStat(notStat);
        dao.update(noticeVO);

        return dao.findByPrimaryKey(notNo);
    }

    public void deleteNO(Integer notNo) {
        dao.delete(notNo);
    }

    public NoticeVO getOneNO(Integer notNo) {
        return dao.findByPrimaryKey(notNo);
    }

    public List<NoticeVO> getAll() {
        return dao.getAll();
    }
}
