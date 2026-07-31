package service;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, Student> userDB;

    public UserService() {
        userDB = new HashMap<>();
    }

    public Student createStudentUser(Student student){
        userDB.put(student.getRollNumber(), student);
        return student;
    }

    public Student getStudent(Integer id){
       return userDB.getOrDefault(id, null);
    }

    public List<Student> getAllStudent(){

        List<Student> listStudent = new ArrayList<>();
        for (Student stud : userDB.values()){
            listStudent.add(stud);
        }
        return listStudent;
    }


}
