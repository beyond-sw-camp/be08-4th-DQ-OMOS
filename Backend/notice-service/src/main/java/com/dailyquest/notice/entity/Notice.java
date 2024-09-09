package com.dailyquest.notice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noticeNo")
    private Long noticeNo; // 공지사항 번호

    @Column(name = "memberNo", nullable = false)
    private Long memberNo; // 회원 번호

    @Column(name = "title", length = 100, nullable = false)
    private String title; // 제목

    @Column(name = "content", nullable = false)
    private String content; // 내용

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt; // 작성시간

    @Column(name = "updateAt")
    private LocalDateTime updateAt; // 수정시간
}
