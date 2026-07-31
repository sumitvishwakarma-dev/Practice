package com.example.demoFilter.service;

import com.example.demoFilter.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public ResponseEntity<Student> createStudent(Student student){
        System.out.println("Student Created");
        Student studentResponse = new Student(
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
        return ResponseEntity.ok(studentResponse);
    }
}
