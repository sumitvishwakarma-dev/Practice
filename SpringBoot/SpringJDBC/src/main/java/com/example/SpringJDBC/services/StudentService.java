package com.example.SpringJDBC.services;


import com.example.SpringJDBC.model.RequestDTO;
import com.example.SpringJDBC.model.ResponseDTO;
import com.example.SpringJDBC.model.Student;
import com.example.SpringJDBC.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Map<String, String> createStudent(RequestDTO requestDTO){

        Map<String,String> responseMap = new HashMap<>();
        if (requestDTO != null){
            Student student = mapToEntity(requestDTO);
            student.setDeleted(false);
            responseMap = studentRepository.saveStudent(student);
        }
        return responseMap;
    }

    public Map<String, String> updateStudent(Long id, RequestDTO requestDTO) {

        Student student = mapToEntity(requestDTO);
        Map<String,String> responseMap = studentRepository.updateStudent(id,student);
        return responseMap;
    }



    public Student mapToEntity(RequestDTO requestDTO){

        Student student = new Student();

        student.setName(requestDTO.getName());
        student.setAge(requestDTO.getAge());
        student.setCreatedAt(LocalDateTime.now());
        student.setEmail(requestDTO.getEmail());
        student.setRollNo(requestDTO.getRollNo());
        student.setStream(requestDTO.getStream());
        student.setSubject(requestDTO.getSubject());
        student.setUpdatedAt(LocalDateTime.now());

        return student;

    }

    public ResponseDTO mapToDTO(Student student){

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setStream(student.getStream());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        return responseDTO;

    }

    public Map<String, String> deleteStudent(Long id) {

        Map<String,String> responseMap = studentRepository.deleteStudent(id);
        return responseMap;
    }

    public Map<String, String> deleteSoft(Long id) {
        Map<String,String> responseMap = studentRepository.softDeleteStudent(id);
        return responseMap;
    }

    public List<ResponseDTO> getStudent() {
        List<ResponseDTO> responseDTO = studentRepository.getStudent();
        return responseDTO;
    }

    public ResponseDTO getStudentById(Long id) {
        ResponseDTO responseDTO = studentRepository.getStudentById(id);
        return responseDTO;
    }


    public List<ResponseDTO> getRecentlyDeleted() {
        List<ResponseDTO> responseDTO = studentRepository.getRecentlyDeleted();
        return responseDTO;
    }
}
