package com.sumitdev.service;

import com.sumitdev.Student;
import com.sumitdev.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceStudent {

    private Repository studentRepo;

    ServiceStudent (Repository studentRepo){
        this.studentRepo = studentRepo;
    }

    public Student create(Student studentReq){
        return studentRepo.createRepo(studentReq);
    }

    public Student get(Long id){
        return studentRepo.getRepo(id);
    }

    public List<Student> getAll(){
        return studentRepo.getALl();
    }


}
