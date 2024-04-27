package com.roger.notice.service.impl;

import com.roger.notice.dao.NoticeRepository;
import com.roger.notice.entity.Notice;
import com.roger.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;


    /**
     * 從資料庫中查找所有 NoticeVO 實例。
     *
     * 這個方法使用 `noticeRepository` 來執行查詢，並返回所有 NoticeVO 實例的列表。
     *
     * @return List<NoticeVO> 包含所有 NoticeVO 實例的列表。
     *         如果沒有記錄，則返回空列表。
     */
    @Override
    public List<Notice> getAll() {
        return noticeRepository.findAll();
    }

}
