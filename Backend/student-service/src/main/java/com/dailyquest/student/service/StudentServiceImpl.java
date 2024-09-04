package com.dailyquest.student.service;

import com.dailyquest.student.dto.StudentDto;
import com.dailyquest.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> studentList() {

        return studentRepository.findAllStudentsWithClassInfo();
    }
}
