package com.sumitdev.employee.services;

import com.sumitdev.employee.dto.RequestDto;
import com.sumitdev.employee.dto.ResponseDto;
import com.sumitdev.employee.dto.UpdatedRequestDto;
import com.sumitdev.employee.dto.UpdatedResponseDto;
import com.sumitdev.employee.entity.Employee;
import com.sumitdev.employee.exceptionhandlers.DuplicateResourceException;
import com.sumitdev.employee.exceptionhandlers.ResourceNotFoundException;
import com.sumitdev.employee.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseDto createEmpDetails(RequestDto requestDto){

        Employee employee = mapToEntity(requestDto);
        if(emailExists(employee)){
            throw new DuplicateResourceException("Employee email "+employee.getEmail()+" is already exists");
        }
        Employee employeeResponse = employeeRepository.save(employee);
        ResponseDto responseDto =  mapToDto(employeeResponse);

        if (employeeResponse != null){
            responseDto.setMessage("Created Successfully");
            return responseDto;
        }
        return responseDto;

    }

    public ResponseDto getEmpDetails(Long id){
        Employee employeeResponse =
                employeeRepository
                        .findByIdAndDeletedIsFalse(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee with id "+id+" not found"));
        return mapToDto(employeeResponse);
    }

    public List<ResponseDto> getAllEmpDetails(){
        List<Employee> allEmployeeResponse =
                employeeRepository
                        .findByDeletedIsFalse();
        return allEmployeeResponse.stream()
                .map(this :: mapToDto)
                .toList();
    }

    public UpdatedResponseDto updateEmpDetails(Long id, UpdatedRequestDto updatedRequestDto){
        Employee existingEmployeeResponse =
                employeeRepository
                .findByIdAndDeletedIsFalse(id)
                        .orElseThrow( () ->
                                new ResourceNotFoundException("Employee with id "+id+" not found"));

        existingEmployeeResponse.setDeleted(false);
        existingEmployeeResponse.setAge(updatedRequestDto.getAge());
        existingEmployeeResponse.setDept(updatedRequestDto.getDept());
        existingEmployeeResponse.setDesignation(updatedRequestDto.getDesignation());
        existingEmployeeResponse.setName(updatedRequestDto.getName());
        existingEmployeeResponse.setSalary(updatedRequestDto.getSalary());

        Employee updatedResponse = employeeRepository.save(existingEmployeeResponse);
        UpdatedResponseDto updatedResponseDto = updatedMapToDto(updatedResponse);
        if (updatedResponseDto != null){
            updatedResponseDto.setMessage("Updated Successfully");
            return updatedResponseDto;
        }
        return updatedResponseDto;

    }

    public void deleteEmpDetails(Long id){
        Employee employeeIsToBeDeleted =
                employeeRepository
                        .findById(id)
                                .orElseThrow(() ->
                                        new ResourceNotFoundException("Employee with id "+id+" not found"));
         employeeRepository.delete(employeeIsToBeDeleted);
    }

    public void softDeleteEmpDetails(Long id){
        Employee employeIsToBeSoftlyDeleted =
                employeeRepository
                        .findByIdAndDeletedIsFalse(id)
                        .orElseThrow(()->
                                new ResourceNotFoundException("Employee with id "+id+" not found"));

        Employee employee = employeIsToBeSoftlyDeleted;
        employee.setDeleted(true);
        employeeRepository.save(employee);
    }

    public List<Employee> recentlySoftDeleted() {
        List<Employee> employee = employeeRepository.findByDeletedIsTrue();
        return employee;
    }

    private Employee mapToEntity(RequestDto requestDto) {
            Employee employeeRequest = new Employee();
            employeeRequest.setName(requestDto.getName());
            employeeRequest.setSalary(requestDto.getSalary());
            employeeRequest.setDept(requestDto.getDept());
            employeeRequest.setAge(requestDto.getAge());
            employeeRequest.setDesignation(requestDto.getDesignation());
            employeeRequest.setEmail(requestDto.getEmail());
            employeeRequest.setCreatedAt(LocalDateTime.now());
            employeeRequest.setUpdatedAt(LocalDateTime.now());
            employeeRequest.setDeleted(false);

            return employeeRequest;
    }

    private ResponseDto mapToDto(Employee employee){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(employee.getId());
        responseDto.setName(employee.getName());
        responseDto.setAge(employee.getAge());
        responseDto.setDept(employee.getDept());
        responseDto.setEmail(employee.getEmail());
        responseDto.setCreatedAt(employee.getCreatedAt());
        responseDto.setUpdatedAt(employee.getUpdatedAt());
        responseDto.setDesignation(employee.getDesignation());
        responseDto.setSalary(employee.getSalary());
        return responseDto;
    }

    private Employee updatedMapToEntity(UpdatedRequestDto upRequestDto) {
        Employee employeeRequest = new Employee();
        employeeRequest.setName(upRequestDto.getName());
        employeeRequest.setSalary(upRequestDto.getSalary());
        employeeRequest.setDept(upRequestDto.getDept());
        employeeRequest.setAge(upRequestDto.getAge());
        employeeRequest.setDesignation(upRequestDto.getDesignation());
        employeeRequest.setCreatedAt(LocalDateTime.now());
        employeeRequest.setUpdatedAt(LocalDateTime.now());
        employeeRequest.setDeleted(false);

        return employeeRequest;
    }

    private UpdatedResponseDto updatedMapToDto(Employee employee){
        UpdatedResponseDto upResponseDto = new UpdatedResponseDto();
        upResponseDto.setId(employee.getId());
        upResponseDto.setName(employee.getName());
        upResponseDto.setAge(employee.getAge());
        upResponseDto.setDept(employee.getDept());
        upResponseDto.setEmail(employee.getEmail());
        upResponseDto.setCreatedAt(employee.getCreatedAt());
        upResponseDto.setUpdatedAt(employee.getUpdatedAt());
        upResponseDto.setDesignation(employee.getDesignation());
        upResponseDto.setSalary(employee.getSalary());
        return upResponseDto;
    }

    private boolean emailExists(Employee employee) {
        return employeeRepository.existsByEmail(employee.getEmail());
    }
}
