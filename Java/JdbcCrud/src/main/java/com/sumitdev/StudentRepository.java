package com.sumitdev;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_jdbcdemo";
    String username = "root";
    String password = "";


    public void createStudent(Student student) {

        String sql = """
                INSERT INTO students(name,email,age)
                VALUES(?,?,?)
                """;
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getAge());

            int rowAffected = statement.executeUpdate();

            if (rowAffected == 0) {
                System.out.println("Student creation failed");
            } else {
                System.out.println("Student creation successful");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void updateStudent(Student student, Long id) {
        String sql = """
                    UPDATE students
                    SET name=?,
                        email=?,
                        age = ?
                    WHERE id=?
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {


            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getAge());
            statement.setLong(4, id);

            int rowAffected = statement.executeUpdate();

            if (rowAffected == 0) {
                System.out.println("Student updation failed");
            } else {
                System.out.println("Student updation successful");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteStudent(Long id) {

        String sql = """
                DELETE FROM students
                WHERE id=?
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setLong(1, id);

            int rowAffected = statement.executeUpdate();

            if (rowAffected == 0) {
                System.out.println("Student deletion failed");
            } else {
                System.out.println("Student deletion successful");
            }

        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }

    }

    public void getStudentById(Long id) {
        String sql = """
                    SELECT id,name,email,age FROM students WHERE id=?
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);

        ) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){
                    Student student = mapResultSet(resultSet);           // Mapping to Student
                    System.out.println(student);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getStudent() {
        String sql = """
                    SELECT id,name,email,age FROM students
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);

        ) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = mapResultSet(resultSet);           // Mapping to Student
                    System.out.println(student);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void studentCrud() {
        String sql = """
                    SELECT id,name,email,age FROM students
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);

        ) {
            boolean resultSet = statement.execute();

            if (resultSet == true) {
                System.out.println("operation done");
            } else {
                System.out.println("operation unsuccessful");
            }

        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public Student mapResultSet(ResultSet resultSet) {
        Student student = new Student();

        try {
            student.setId(resultSet.getLong("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            student.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        return student;
    }


}
