package com.dailyquest.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_no")
    private Long studentNo; // 학생 번호

    @Column(name = "class_no", nullable = false)
    private Long classNo; // 클래스 번호

    @Column(name = "email", nullable = false, unique = true)
    private String email; // 이메일

    @Column(name = "name", nullable = false)
    private String name; // 학생 이름

    @Column(name = "phone", nullable = false)
    private String phone; // 전화번호

    @Column(name = "address", nullable = false)
    private String address; // 주소
}
