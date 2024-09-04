package com.dailyquest.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_no")
    private Long classNo; // 클래스 번호

    @Column(name = "name", nullable = false)
    private String name; // 클래스 이름

    @Column(name = "teacher", nullable = false)
    private String teacher; // 강사 이름

    @Column(name = "open_dt", nullable = false)
    private LocalDate openDt; // 개강일

    @Column(name = "close_dt", nullable = false)
    private LocalDate closeDt; // 종강일
}
