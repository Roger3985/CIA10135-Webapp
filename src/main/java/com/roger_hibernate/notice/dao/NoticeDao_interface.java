package com.roger_hibernate.notice.dao;

import com.roger_hibernate.notice.vo.NoticeVO;

import java.util.List;

public interface NoticeDao_interface {

    public void insert(NoticeVO noticeVO);
    public void update(NoticeVO noticeVO);
    public void delete(Integer motNo);
    public NoticeVO findByPrimaryKey(Integer motNo);
    public List<NoticeVO> getAll();

}
