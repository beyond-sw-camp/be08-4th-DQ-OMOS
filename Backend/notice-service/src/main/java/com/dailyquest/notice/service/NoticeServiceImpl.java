package com.dailyquest.notice.service;

import com.dailyquest.notice.entity.Notice;
import com.dailyquest.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl {
    private final NoticeRepository noticeRepository;

    public List<Notice> noticeList() {
        return noticeRepository.findAll();
    }
}
