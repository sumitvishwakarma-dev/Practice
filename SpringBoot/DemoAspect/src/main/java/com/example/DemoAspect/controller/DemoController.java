package com.example.DemoAspect.controller;

import com.example.DemoAspect.aspects.DecoratorAspects;
import com.example.DemoAspect.dto.Student;
import com.example.DemoAspect.services.DemoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class DemoController {

    private DemoService demoService;

    DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student
    ){
        Student s = demoService.createStudent(student);
        return ResponseEntity.ok(s);
    }

//    @PostMapping
//    public ResponseEntity<String> greetName(
//            @RequestBody String name
//    ){
//        String upperName = demoService.greetStudent(name);
//        return ResponseEntity.ok(upperName);
//    }

    @GetMapping
    public ResponseEntity<String> getStudent(){
        String s = demoService.getStudent();
        return ResponseEntity.ok(s);
    }
}
