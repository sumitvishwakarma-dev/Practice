package com.sumitdev.employee.repository;

import com.sumitdev.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Optional<Employee> findByIdAndDeletedIsFalse(Long id);

    List<Employee> findByDeletedIsFalse();

    List<Employee> findByDeletedIsTrue();

    boolean existsByEmail(String employeeEmail);
}
