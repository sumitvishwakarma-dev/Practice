package com.sumitdev.SpringHibernate.services;

import com.sumitdev.SpringHibernate.model.Student;
import com.sumitdev.SpringHibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void saveStudent(Student student) {
        student.setCreatedAt(LocalDateTime.now());
        studentRepository.saveStudent(student);
    }

    @Transactional
    public void updateStudent(Student student, Long id) {
        Student responseStudent = studentRepository.getStudentById(id);

        responseStudent.setName(student.getName());
        responseStudent.setAge(student.getAge());
        if(student.getEmail() != null){
            throw new RuntimeException("Email id cannot be editable");
        }

    }

    @Transactional
    public Student getStudentById(Long id) {
        Student student = studentRepository.getStudentById(id);
        return student;
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    @Transactional
    public void getStudent() {
        studentRepository.getStudent();
    }


}
