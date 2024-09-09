package com.dailyquest.notice.controller;

import com.dailyquest.notice.dto.NoticeDto;
import com.dailyquest.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    // 공지사항 목록 불러오기
    @GetMapping("/noticeList")
    public ResponseEntity<List<NoticeDto>> noticeList() {
        List<NoticeDto> noticeDtoList = noticeService.noticeList();
        System.out.println("noticeDtoList = " + noticeDtoList);
        return ResponseEntity.ok(noticeDtoList);
    }



}