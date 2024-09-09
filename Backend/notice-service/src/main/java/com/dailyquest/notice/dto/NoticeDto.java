package com.dailyquest.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDto {
    private Long noticeNo; // 공지사항 번호
    private Long memberNo; // 회원 번호
    private String noticeTitle; // 제목
    private String noticeContent; // 내용
    private LocalDateTime createdAt; // 작성시간
    private LocalDateTime updateAt; // 수정시간

}
