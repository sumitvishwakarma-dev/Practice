package com.sumitdev.springJPAHibernate.repository;

import com.sumitdev.springJPAHibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public String deleteStudent(Long id){
        entityManager.remove(id);
        return "Student deleted";
    }

    public Student getStudentById(Long id){
        Student responseStudent = entityManager.find(Student.class,id);
        return responseStudent;
    }

}
