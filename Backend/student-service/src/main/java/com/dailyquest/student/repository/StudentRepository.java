package com.dailyquest.student.repository;

import com.dailyquest.student.dto.StudentDto;
import com.dailyquest.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JPQL 쿼리를 사용하여 Student와 Class를 조인하고 결과를 StudentDto로 매핑하는 메서드
    @Query("SELECT new com.dailyquest.student.dto.StudentDto(s.studentNo, s.name, s.email, s.phone, s.address, " +
            "c.classNo, c.name, c.teacher, c.openDt, c.closeDt) " +
            "FROM Student s JOIN Class c ON s.classNo = c.classNo")
    List<StudentDto> findAllStudentsWithClassInfo();

}
