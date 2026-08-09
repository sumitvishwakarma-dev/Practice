package com.sumitdev.hibernateCascade.repository;

import com.sumitdev.hibernateCascade.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

    public void removeDept(Department department) {
        entityManager.remove(department);
    }

    public Department findDept(Long id) {
        Department dept = entityManager.find(Department.class,id);
        return dept;
    }
}
