package com.example.demoCustomSpringAOP.services;

import com.example.demoCustomSpringAOP.annotations.EvaluateExecutionTimeAOP;
import com.example.demoCustomSpringAOP.annotations.MakeItUpperCase;
import com.example.demoCustomSpringAOP.dto.Student;
import org.springframework.stereotype.Service;


@Service
public class CustomSpringAOPService {

    @MakeItUpperCase(
            warnTime = 1600
    )
    @EvaluateExecutionTimeAOP(
            warnTime = 1500,
            operation = " Student created"
    )
    public Student createStudent(Student student) {
        System.out.println("In service ..");
        return student;
    }
}
