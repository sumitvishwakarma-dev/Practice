package com.sumitdev.controller;

import com.sumitdev.Student;
import com.sumitdev.service.ServiceStudent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class ControllerStudent {

    private final ServiceStudent serviceStudent;

    ControllerStudent(ServiceStudent serviceStudent){
        this.serviceStudent = serviceStudent;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student responseCreate = serviceStudent.create(student);
        if (responseCreate == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseCreate);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id){
        Student student =  serviceStudent.get(id);
        if (student == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentResponse =  serviceStudent.getAll();
        if (studentResponse == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(studentResponse);
        }
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(studentResponse);
    }
}
