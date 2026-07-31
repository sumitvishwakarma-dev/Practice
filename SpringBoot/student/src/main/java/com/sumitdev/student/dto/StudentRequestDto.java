package com.sumitdev.student.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDto {

    @NotBlank(message = "Name must not be null/empty or blank")
    @Size(min = 2,max = 50, message = "Name must be between 2 to 50 character long")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student must be 18")
    private int age;

    @NotNull(message = "Roll no is required")
    private int rollNo;
    @NotBlank(message = "Subject is required")
    private String subject;
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Stream is required")
    private String stream;

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

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}
