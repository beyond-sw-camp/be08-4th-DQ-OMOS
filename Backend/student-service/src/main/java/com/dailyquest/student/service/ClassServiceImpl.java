package com.dailyquest.student.service;

import com.dailyquest.student.entity.Class;
import com.dailyquest.student.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService{

    private final ClassRepository classRepository;

    @Override
    public List<String> getClassNames() {
        return classRepository.findAll().stream()
                .map(Class::getName)
                .collect(Collectors.toList());
    }
}
