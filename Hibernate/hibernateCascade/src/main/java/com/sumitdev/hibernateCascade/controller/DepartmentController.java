package com.sumitdev.hibernateCascade.controller;

import com.sumitdev.hibernateCascade.model.Department;
import com.sumitdev.hibernateCascade.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }

    @DeleteMapping
    public String deleteDept(@RequestParam Long id){
        departmentService.remove(id);
        return "deleted";
    }

    @GetMapping
    public ResponseEntity<Department> findDept(@RequestParam Long id){
        Department department = departmentService.findDept(id);
        return ResponseEntity.ok(department);
    }



}
