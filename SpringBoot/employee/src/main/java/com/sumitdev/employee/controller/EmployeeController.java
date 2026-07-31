package com.sumitdev.employee.controller;

import com.sumitdev.employee.dto.RequestDto;
import com.sumitdev.employee.dto.ResponseDto;
import com.sumitdev.employee.dto.UpdatedRequestDto;
import com.sumitdev.employee.dto.UpdatedResponseDto;
import com.sumitdev.employee.entity.Employee;
import com.sumitdev.employee.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createEmployeeDetails(@Valid @RequestBody RequestDto requestDto){

        ResponseDto response = employeeService.createEmpDetails(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getDetails( @PathVariable Long id){

        ResponseDto response = employeeService.getEmpDetails(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> getDetails(){
        List<ResponseDto> response = employeeService.getAllEmpDetails();
        if (response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<UpdatedResponseDto> updateDetails(@RequestParam Long id,
                                                @Valid  @RequestBody UpdatedRequestDto updatedRequestDto){
        UpdatedResponseDto response = employeeService.updateEmpDetails(id,updatedRequestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDetails(@RequestParam Long id){
        employeeService.deleteEmpDetails(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftDetails(@RequestParam Long id){
        employeeService.softDeleteEmpDetails(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/recently-deleted")
    public ResponseEntity<List<Employee>> recentlySoftDeleted(){
        List<Employee> employee = employeeService.recentlySoftDeleted();
        if(employee == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employee);
    }

}
