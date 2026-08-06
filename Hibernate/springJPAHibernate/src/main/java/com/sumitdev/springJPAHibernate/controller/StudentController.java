package com.sumitdev.springJPAHibernate.controller;

import com.sumitdev.springJPAHibernate.model.Student;
import com.sumitdev.springJPAHibernate.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student,
                                               @RequestParam Long id){
        Student studentResponse = studentService.saveStudent(student,id);
        return ResponseEntity.ok(studentResponse);
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<Student> saveStudentWithDeptName(@RequestBody Student student,
                                                           @RequestParam String name){
        Student studentResponse = studentService.saveStudentWitjDeptName(student,name);
        return ResponseEntity.ok(studentResponse);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){

        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping
    public ResponseEntity<Student> getStudentById(@RequestParam Long id){
        Student studentResponse = studentService.getStudentById(id);
        return ResponseEntity.ok(studentResponse);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                                @RequestParam Long id){
        Student studentResponse = studentService.update(student,id);
        return ResponseEntity.ok(studentResponse);
    }


}
