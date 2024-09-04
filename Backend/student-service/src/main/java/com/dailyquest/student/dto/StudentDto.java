package com.dailyquest.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private long studentNo;     // 학생 번호
    private String studentName; // 학생 이름
    private String email;       // 이메일
    private String phone;       // 전화번호
    private String address;     // 주소

    private long classNo;       // 클래스 번호
    private String className;   // 클래스 이름
    private String teacher;     // 강사 이름
    private LocalDate openDt;   // 개강일
    private LocalDate closeDt;  // 종강일

}
