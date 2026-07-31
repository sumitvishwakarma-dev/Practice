package com.sumitdev.student.controller;

import com.sumitdev.student.dto.StudentRequestDto;
import com.sumitdev.student.dto.StudentResponseDto;
import com.sumitdev.student.entity.Student;
import com.sumitdev.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudentDetail(@Valid @RequestBody StudentRequestDto studentRequestDto){

        StudentResponseDto studentResponse = studentService.createStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponseDto> getStudentDetail(@PathVariable Long id){
        StudentResponseDto studentResponse = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(studentResponse);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudentDetail(){
        List<StudentResponseDto> studentResponse = studentService.getALlStudentDetails();
        if(studentResponse == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(studentResponse);
    }

    @PutMapping
    public ResponseEntity<StudentResponseDto> updateStudentDetail(@RequestParam Long id,
                                                     @Valid @RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto studentResponse = studentService.updateStudentById(id,studentRequestDto);
        return ResponseEntity.ok(studentResponse);
    }

    @DeleteMapping
    public ResponseEntity<StudentResponseDto> deleteStudentDetail(@RequestParam Long id){
        studentService.deleteStudentById(id);

        return ResponseEntity
                .noContent().build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<StudentResponseDto> softlyDeleteStudentDetail(@RequestParam Long id){
                studentService.softlyDeleteStudentById(id);

        return ResponseEntity
                .noContent().build();
    }

    @GetMapping("/recently-deleted")
    public ResponseEntity<List<StudentResponseDto>> recentlyDeleteStudentDetail(){
        List<StudentResponseDto> studentResponse = studentService.recentlySoftDeleted();
        if (studentResponse == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(studentResponse);
    }


}
