package com.example.SpringJDBC.respository;


import com.example.SpringJDBC.exceptions.ConnectionErrorException;
import com.example.SpringJDBC.exceptions.ResourceNotFoundException;
import com.example.SpringJDBC.model.ResponseDTO;
import com.example.SpringJDBC.model.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    private StudentRowMapper studentRowMapper= new StudentRowMapper();

    public  StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public Map<String,String> saveStudent(Student student){

        String sql = """
                INSERT INTO student
                (name,age,roll_no,email,stream,subject, created_at, updated_at,deleted)
                VALUES(?,?,?,?,?,?,?,?,?)
                """;

        int rowAffected = jdbcTemplate.update(sql,
                student.getName(),
                student.getAge(),
                student.getRollNo(),
                student.getEmail(),
                student.getStream(),
                student.getSubject(),
                student.getCreatedAt(),
                student.getUpdatedAt(),
                student.getDeleted());

        Map<String,String> map = new HashMap<>();

        if (rowAffected == 0){
            throw new ConnectionErrorException("Connection Error");

        }else {
            map.put("MESSAGE","Student saved successfully");
            map.put("STATUS_CODE","201");
            System.out.println("Student Saved");
        }
        return map;
    }

    public Map<String,String> updateStudent(Long id, Student student) {
        String sql = """
                UPDATE student
                SET name=?,
                    age=?,
                    email=?,
                    stream=?,
                    subject=?,
                    roll_no=?,
                    updated_at=?
                WHERE id=?
                """;
        int rowAffected = jdbcTemplate.update(sql,student.getName(),student.getAge(),student.getEmail(),
                student.getStream(),student.getSubject(),student.getRollNo(),
                LocalDateTime.now(),id);

        Map<String,String> map = new HashMap<>();

        if (rowAffected == 0){
            throw new ResourceNotFoundException("Given id "+id+ " NOT FOUND");
        }else {
            map.put("MESSAGE","Student UPDATED");
            map.put("STATUS_CODE","200");
            System.out.println("Student UPDATED");
        }
        return map;
    }

    public Map<String, String> deleteStudent(Long id) {

        String sql = """
                DELETE FROM student WHERE id=?
                """;

        int rowAffected = jdbcTemplate.update(sql,id);

        Map<String,String> map = new HashMap<>();

        if (rowAffected == 0){
            throw new ResourceNotFoundException("Given id "+id+ " NOT FOUND");
        }else {
            map.put("MESSAGE","Student DELETED");
            map.put("STATUS_CODE","200");
        }
        return map;

    }

    public Map<String, String> softDeleteStudent(Long id) {

        String sql = """
                UPDATE student
                SET deleted=?
                WHERE id=?
                """;

        int rowAffected = jdbcTemplate.update(sql, 1,id);

        Map<String,String> map = new HashMap<>();

        if (rowAffected == 0){
            throw new ResourceNotFoundException("Given id "+id+ " NOT FOUND");
        }else {
            map.put("MESSAGE","Student UPDATED");
            map.put("STATUS_CODE","200");
            System.out.println("Student UPDATED");
        }
        return map;
    }

    public List<ResponseDTO> getStudent() {

        String sql = """
                SELECT * FROM student WHERE deleted=?
                """;
        try{
            List<ResponseDTO> students = jdbcTemplate.query(sql, studentRowMapper,0);
            return students;
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new ResourceNotFoundException("Not Found Any Data");
        }
    }

    public ResponseDTO getStudentById(Long id) {
        String sql = """
                SELECT * FROM student WHERE id=? AND deleted=?
                """;

        try{
            ResponseDTO students = jdbcTemplate.queryForObject(sql, studentRowMapper, id,0);
            return students;
        }
        catch (EmptyResultDataAccessException e) {
           throw new ResourceNotFoundException("Given id " +id+ " NOT FOUND");
        }

    }

    public List<ResponseDTO> getRecentlyDeleted() {
        String sql = """
                SELECT * FROM student WHERE deleted=?
                """;
        try{
            List<ResponseDTO> students = jdbcTemplate.query(sql, studentRowMapper,1);
            return students;
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new ResourceNotFoundException("Not Found Any Data");
        }
    }
}
