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

    public NoticeVO updateNO(Integer motNo, Integer memNo, String notContent, Timestamp notTime, Byte notStat) {

        NoticeVO noticeVO = new NoticeVO();

        noticeVO.setMotNo(motNo);
        noticeVO.setMemNo(memNo);
        noticeVO.setNotContent(notContent);
        noticeVO.setNotTime(notTime);
        noticeVO.setNotStat(notStat);
        dao.update(noticeVO);

        return dao.findByPrimaryKey(motNo);
    }

    public void deleteNO(Integer motNo) {
        dao.delete(motNo);
    }

    public NoticeVO getOneNO(Integer motNo) {
        return dao.findByPrimaryKey(motNo);
    }

    public List<NoticeVO> getAll() {
        return dao.getAll();
    }
}
