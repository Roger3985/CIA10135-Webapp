package com.roger.notice.controller;

import com.roger.notice.entity.Notice;
import com.roger.notice.service.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeControllerFrontEnd {

    @Autowired
    private NoticeServiceImpl noticeService;

    // 全部json到前端
    @GetMapping("/getAllNotices")
    public ResponseEntity<List<Notice>> getAllNotices() {
        Notice notice = new Notice();
        List<Notice> notices = noticeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(notices);
    }
}
