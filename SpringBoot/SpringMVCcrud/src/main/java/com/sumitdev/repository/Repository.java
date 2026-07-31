package com.sumitdev.repository;

import com.sumitdev.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {

    Map<Long, Student> studentDB;

    public Repository() {
        studentDB = new HashMap<>();
    }

    public Student createRepo(Student student){
        studentDB.put(student.getId(),student);
        return student;
    }

    public Student getRepo(Long id){
        return  studentDB.get(id);
    }

    public List<Student> getALl(){
        return new ArrayList<>(studentDB.values());
    }
 }
