package com.sumitdev.employee.dto;

import jakarta.validation.constraints.*;

public class RequestDto {

    @NotBlank(message = "Name cannot be null/empty or blank")
    @Size(min = 2, max = 50, message = "Name should be between 2 to 50 characters")
    private String name;

    @Min(value = 18, message = "Age should be above or equal to 18")
    @NotNull(message = "Age is required")
    private int age;

    @NotNull(message = "Salary required")
    @Min(value = 5000)
    @Max(value = 1000000000, message = "Salary should be between 5k to 100cr")
    private double salary;

    @NotBlank(message = "Department cannot be null/empty or blank")
    @Size(min = 2, max = 25, message = "Department should be between 2 to 25 characters")
    private String dept;

    @NotBlank(message = "Designation cannot be null/empty or blank")
    @Size(min = 2, max = 25, message = "Designation should be between 2 to 25 characters")
    private String designation;

    @Email(message = "Email must be valid")
    @NotNull(message = "Email required")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
