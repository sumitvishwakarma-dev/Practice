package com.sumitdev.springJPAHibernate.controller;

import com.sumitdev.springJPAHibernate.model.Department;
import com.sumitdev.springJPAHibernate.model.Student;
import com.sumitdev.springJPAHibernate.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    DepartmentController(@RequestBody DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        Department departmentResponse = departmentService.saveDepartment(department);
        return ResponseEntity.ok(departmentResponse);
    }


    @PostMapping("/withStudentName")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department,
                                                     @RequestParam String studentName ){
        Department departmentResponse = departmentService.saveDepartment(department, studentName);
        return ResponseEntity.ok(departmentResponse);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDepartment(@RequestParam Long id){
        String response =  departmentService.deleteDepartment(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Department> getDepartment(@RequestParam Long id){
        Department response =  departmentService.getDepartment(id);
        return ResponseEntity.ok(response);
    }
}
