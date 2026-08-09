package com.sumitdev.hibernateCascade.services;

import com.sumitdev.hibernateCascade.model.Department;
import com.sumitdev.hibernateCascade.model.Student;
import com.sumitdev.hibernateCascade.repository.DepartmentRepository;
import com.sumitdev.hibernateCascade.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void createDepartment(Department department) {

        Student s1 = new Student();
        s1.setName("Sumit");
        s1.setDepartment(department);

        Student s2 = new Student();
        s2.setName("Amit");
        s2.setDepartment(department);

        department.getStudents().addAll(List.of(s1,s2));
        departmentRepository.save(department);

    }

    @Transactional
    public void remove(Long id){
        Department department = departmentRepository.findDept(id);
        departmentRepository.removeDept(department);
    }

    @Transactional
    public Department findDept(Long id) {
        return departmentRepository.findDept(id);
    }
}
