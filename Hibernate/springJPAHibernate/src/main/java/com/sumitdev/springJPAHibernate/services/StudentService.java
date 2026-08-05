package com.sumitdev.springJPAHibernate.services;

import com.sumitdev.springJPAHibernate.model.Department;
import com.sumitdev.springJPAHibernate.model.Student;
import com.sumitdev.springJPAHibernate.repository.DepartmentRepository;
import com.sumitdev.springJPAHibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    StudentService(StudentRepository studentRepository,
                   DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }


    @Transactional
    public Student saveStudent(Student student,Long id) {

        Department department = departmentRepository.getDepartment(id);
        student.setDepartment(department);
        department.getStudents().add(student);
        Student studentResponse = studentRepository.saveStudent(student);
        return studentResponse;
    }

    @Transactional
    public Student saveStudent(Student student,String deptName) {

        Department department = departmentRepository.getDepartment(deptName);
        student.setDepartment(department);
        department.getStudents().add(student);
        Student studentResponse = studentRepository.saveStudent(student);
        return studentResponse;
    }

    @Transactional
    public String deleteStudent(Long id) {
         return studentRepository.deleteStudent(id);
    }

    @Transactional
    public Student getStudentById(Long id) {
        Student studentResponse = studentRepository.getStudentById(id);
        return studentResponse;
    }

    @Transactional
    public Student update(Student student, Long id) {
        Student responseStudent = studentRepository.getStudentById(id);
        if (responseStudent == null){
            throw new RuntimeException("Id "+id+" NOT FOUND");
        }
        responseStudent.setName(student.getName());
        responseStudent.setDepartment(student.getDepartment());

        return responseStudent;
    }
}
