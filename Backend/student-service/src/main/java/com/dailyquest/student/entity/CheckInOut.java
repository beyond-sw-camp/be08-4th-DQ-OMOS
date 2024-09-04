package com.dailyquest.student.entity;

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
@Table(name = "tb_check_in_out")
public class CheckInOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_no")
    private Long checkNo; // 입퇴실 번호

    @Column(name = "student_no", nullable = false)
    private Long studentNo; // 학생 번호

    @Column(name = "time", nullable = false)
    private LocalDateTime time; // 시간

    @Enumerated(EnumType.STRING)
    @Column(name = "check_type")
    private CheckType type; // 입퇴실 종류
}
