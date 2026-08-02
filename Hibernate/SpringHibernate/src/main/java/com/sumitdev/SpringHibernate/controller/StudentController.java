package com.sumitdev.SpringHibernate.controller;

import com.sumitdev.SpringHibernate.model.Student;
import com.sumitdev.SpringHibernate.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        studentService.saveStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student,
                                                @RequestParam Long id){

        studentService.updateStudent(student,id);
        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){

        studentService.deleteStudent(id);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping
    public ResponseEntity<String> getStudent(){

        studentService.getStudent();
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/getById")
    public ResponseEntity<Student> getStudentById(@RequestParam Long id){

        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
}
