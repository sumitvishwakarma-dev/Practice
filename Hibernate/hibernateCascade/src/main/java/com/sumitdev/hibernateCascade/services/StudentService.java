package com.sumitdev.hibernateCascade.services;

import com.sumitdev.hibernateCascade.model.Department;
import com.sumitdev.hibernateCascade.model.Student;
import com.sumitdev.hibernateCascade.repository.DepartmentRepository;
import com.sumitdev.hibernateCascade.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    StudentService(
                      StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void remove(Long id){
        studentRepository.removeStudent(id);
    }

    @Transactional
    public Student findStudent(Long id) {
        return studentRepository.findStudent(id);
    }
}
