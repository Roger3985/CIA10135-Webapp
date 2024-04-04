package service;

import VO.NoticeVO;
import dao.Impl.NoticeDaoImpl;
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

    public List<NoticeVO> getAll() {
        return dao.getAll();
    }
}
