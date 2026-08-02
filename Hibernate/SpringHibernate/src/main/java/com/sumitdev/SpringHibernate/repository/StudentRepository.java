package com.sumitdev.SpringHibernate.repository;

import com.sumitdev.SpringHibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    //save
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    //remove
    public void deleteStudent(Long id) {
        entityManager.remove(id);
    }

    //get
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void getStudent() {
    }


}
