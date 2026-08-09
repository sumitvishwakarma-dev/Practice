package com.sumitdev.hibernateCascade.controller;


import com.sumitdev.hibernateCascade.model.Department;
import com.sumitdev.hibernateCascade.model.Student;
import com.sumitdev.hibernateCascade.services.DepartmentService;
import com.sumitdev.hibernateCascade.services.StudentService;
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
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok("Done");
    }

    @DeleteMapping
    public String deleteStudent(@RequestParam Long id){
        studentService.remove(id);
        return "deleted";
    }

    @GetMapping
    public ResponseEntity<Student> findDept(@RequestParam Long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

}
