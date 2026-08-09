package com.sumitdev.hibernateCascade.repository;

import com.sumitdev.hibernateCascade.model.Department;
import com.sumitdev.hibernateCascade.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }

    public void removeStudent(Long id) {
        entityManager.remove(id);
    }

    public Student findStudent(Long id) {
       return entityManager.find(Student.class,id);
    }
}
