package com.dailyquest.student.service;

import com.dailyquest.student.dto.StudentDto;

import java.util.List;

public interface StudentService {

    /*
        모든 학생 정보 리스트
     */
    List<StudentDto> studentList();
}
