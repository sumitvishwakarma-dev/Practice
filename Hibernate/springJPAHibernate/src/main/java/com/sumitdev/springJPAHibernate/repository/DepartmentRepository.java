package com.sumitdev.springJPAHibernate.repository;

import com.sumitdev.springJPAHibernate.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Department saveDepartment(Department department) {

        entityManager.persist(department);
        return department;
    }


    public Department getDepartment(Long id){
        return entityManager.find(Department.class,id);
    }

    public Department getDepartment(String deptName){
        return entityManager.find(Department.class,deptName);
    }


    public String deleteDepartment(Long id){
        entityManager.remove(id);
        return "Deleted";
    }
}
