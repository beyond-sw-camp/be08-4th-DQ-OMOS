package com.dailyquest.student.controller;

import com.dailyquest.student.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/class")
public class ClassController {

    private final ClassService classService;

    @GetMapping("/classNames")
    public ResponseEntity<List<String>> getClassNames() {
        List<String> classNames = classService.getClassNames();
        return ResponseEntity.ok(classNames);
    }
}
