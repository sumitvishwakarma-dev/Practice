package com.sumitdev.springJPAHibernate.services;

import com.sumitdev.springJPAHibernate.model.Department;
import com.sumitdev.springJPAHibernate.model.Student;
import com.sumitdev.springJPAHibernate.repository.DepartmentRepository;
import com.sumitdev.springJPAHibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    DepartmentService(DepartmentRepository departmentRepository,
                      StudentRepository studentRepository){
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.saveDepartment(department);
    }

    @Transactional
    public void saveDepartmentWithStudent(Department department,String name) {

        Student student = new Student();
        student.setName(name);
        student.setDepartment(department);

        department.getStudents().add(student);

        departmentRepository.saveDepartment(department);
        studentRepository.saveStudent(student);
    }

    @Transactional
    public String deleteDepartment(Long id) {
        return departmentRepository.deleteDepartment(id);
    }

    @Transactional
    public Department getDepartment(Long id) {
        return departmentRepository.getDepartmentById(id);
    }
}
