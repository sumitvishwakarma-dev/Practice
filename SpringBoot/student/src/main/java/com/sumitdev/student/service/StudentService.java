package com.sumitdev.student.service;

import com.sumitdev.student.dto.StudentRequestDto;
import com.sumitdev.student.dto.StudentResponseDto;
import com.sumitdev.student.entity.Student;
import com.sumitdev.student.exceptionhandler.DuplicateResourceExceptionHandler;
import com.sumitdev.student.exceptionhandler.ResourceNotFoundException;
import com.sumitdev.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto createStudent(StudentRequestDto studentReq){

        Student student = mapToEntity(studentReq);
        if (emailExists(student.getEmail())){
            throw new DuplicateResourceExceptionHandler("Student with email id "+student.getEmail()+" is already exists");
        }
        student.setDeleted(false);
        Student responseStudent =
                studentRepository.save(student);
        StudentResponseDto studentResponseDto = mapToDto(responseStudent);
        if (studentResponseDto != null){
            studentResponseDto.setMessage("Created Successfully");
        }
        return studentResponseDto;
    }

    public StudentResponseDto getStudentById(Long id){
       Student getResponseStudent=
               studentRepository.findByIdAndDeletedIsFalse(id)
                       .orElseThrow(() -> new ResourceNotFoundException("Student details with id "+id+" Not found"));
         StudentResponseDto studentResponseDto = mapToDto(getResponseStudent);
       return studentResponseDto;
    }

    public List<StudentResponseDto> getALlStudentDetails(){
        List<Student> getResponseStudent=
                studentRepository.findByDeletedIsFalse();
        return getResponseStudent.stream()
                .map(this::mapToDto)
                .toList();
    }

    public StudentResponseDto updateStudentById(Long id, StudentRequestDto studentReq){
        Student getResponseStudent=
                studentRepository.findByIdAndDeletedIsFalse(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" is not found"));

        Student student = getResponseStudent;

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        student.setRollNo(studentReq.getRollNo());
        student.setSubject(studentReq.getSubject());
        student.setDeleted(false);
        student.setStream(studentReq.getStream());
        student.setUpdatedAt(LocalDateTime.now());

        Student studentResponse = studentRepository.save(student);
        StudentResponseDto studentResponseDto = mapToDto(studentResponse);
        if (studentResponseDto != null){
            studentResponseDto.setMessage("Updated Successfully");
        }
        return studentResponseDto;
    }

    public void deleteStudentById(Long id){
       studentRepository
               .findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" is not found"));
       studentRepository.deleteById(id);
    }

    public void softlyDeleteStudentById(Long id){
        Student isDeletedResponse = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" is not found"));

        Student student = isDeletedResponse;
        student.setDeleted(true);
        studentRepository.save(student);
    }

    public List<StudentResponseDto> recentlySoftDeleted(){
        List<Student> student = studentRepository.findByDeletedIsTrue();
        return student
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private Student mapToEntity(StudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setSubject(studentRequestDto.getSubject());
        student.setAge(studentRequestDto.getAge());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setStream(studentRequestDto.getStream());
        student.setEmail(studentRequestDto.getEmail());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private StudentResponseDto mapToDto(Student student){
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setSubject(student.getSubject());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setStream(student.getStream());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setCreatedAt(student.getCreatedAt());
        studentResponseDto.setUpdatedAt(student.getUpdatedAt());
        return studentResponseDto;
    }

    private boolean emailExists(String email) {

        boolean emailExists = studentRepository.existsByEmail(email);
        return emailExists;
    }

}
