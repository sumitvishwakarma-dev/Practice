package com.example.demoCustomSpringAOP.controller;

import com.example.demoCustomSpringAOP.dto.Student;
import com.example.demoCustomSpringAOP.services.CustomSpringAOPService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customAOP/")
public class CustomSpringAOP {

    private final CustomSpringAOPService customSpringAOPService;

    CustomSpringAOP(CustomSpringAOPService customSpringAOPService){
        this.customSpringAOPService = customSpringAOPService;
    }

    @PostMapping
    public Student createStudent(
            @RequestBody Student student
    ){
        return customSpringAOPService.createStudent(student);
    }

}
