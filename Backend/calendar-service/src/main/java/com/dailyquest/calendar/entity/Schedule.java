package com.dailyquest.calendar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_no", nullable = false)
    private Long scheduleNo; // 일정 번호

    @Column(name = "class_no")
    private Long classNo; // 반 번호

    @Column(name = "title", length = 100, nullable = false)
    private String title; // 일정 이름

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description; // 일정 내용

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime; // 시작 시간

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime; // 종료 시간

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ScheduleType type; // 일정 종류
}
