package com.example.SpringJDBC.controller;

import com.example.SpringJDBC.model.RequestDTO;
import com.example.SpringJDBC.model.ResponseDTO;
import com.example.SpringJDBC.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<Map<String,String>> createStudent(@RequestBody RequestDTO requestDTO){

        Map<String,String> responseMap = studentService.createStudent(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseMap);

    }

    @PutMapping
    public ResponseEntity<Map<String,String>> updateStudent(@RequestParam Long id,
                                                            @RequestBody RequestDTO requestDTO){
        Map<String, String> responseMap = studentService.updateStudent(id,requestDTO);
        return ResponseEntity.ok(responseMap);
    }

    @DeleteMapping
    public ResponseEntity<Map<String,String>> deleteStudent(@RequestParam Long id){
        Map<String, String> responseMap = studentService.deleteStudent(id);
        return ResponseEntity.ok(responseMap);
    }

    @PutMapping("/softDelete")
    public ResponseEntity<Map<String,String>> softDelete(@RequestParam Long id){
        Map<String,String> responseMap = studentService.deleteSoft(id);
        return ResponseEntity.ok(responseMap);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getStudent(){
        List<ResponseDTO> responseList = studentService.getStudent();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/getById")
    public ResponseEntity<ResponseDTO> getStudentById(@RequestParam Long id){
        ResponseDTO responseList = studentService.getStudentById(id);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("recentlyDeleted")
    public ResponseEntity<List<ResponseDTO>> getRecentlyDeleted(){
        List<ResponseDTO> responseList = studentService.getRecentlyDeleted();
        return ResponseEntity.ok(responseList);
    }




}
