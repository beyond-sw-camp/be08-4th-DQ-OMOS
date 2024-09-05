package com.dailyquest.student.controller;

import com.dailyquest.student.dto.StudentDto;
import com.dailyquest.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/studentList")
    public ResponseEntity<List<StudentDto>> studentList(){

        List<StudentDto> studentDtoList = studentService.studentList();
        System.out.println("studentDtoList = " + studentDtoList);
        return ResponseEntity.ok(studentDtoList);
    }

}
