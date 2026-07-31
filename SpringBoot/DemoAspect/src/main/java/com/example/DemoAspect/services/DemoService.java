package com.example.DemoAspect.services;

import com.example.DemoAspect.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class DemoService {



    public Student createStudent(Student student){
        System.out.println("Student saved");
        return student;
    }

    public String getStudent(){
        System.out.println("Student provided");
        return "Student Given";
    }

    public String greetStudent(String name){
        return "Hello" +name;
    }

}
