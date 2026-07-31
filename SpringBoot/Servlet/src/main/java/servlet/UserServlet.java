package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService() ;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        if(idParam == null){
            List<Student> list = userService.getAllStudent();

            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(userToJsonList(list));
            return;
        }

        Integer id = Integer.parseInt(request.getParameter("id"));

        Student student = userService.getStudent(id);

        if (student == null){
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"message\":\"User Creatation failed\"\n" +
                    "}"
            );        }else {

            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(userToJson(student));
        }

    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if(id == null || name == null || email == null || mobile == null){

            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"message\":\"User Creatation failed\"\n" +
                    "}"
            );
            return;

        }
        Student student = new Student(id, name,email,mobile);

        Student createdStudent = userService.createStudentUser(student);

        response.setContentType("application/json");
        response.setStatus(201);
        response.getWriter().write("{\n" +
                "    \"message\":\"User Created\"\n" +
                "}"
        );


    }

    public void doPut(){

    }

    public void doDelete(){

    }

    public String userToJson(Student student){
        return "{\n" +
                "    \"id\":"+ student.getRollNumber()+",\n" +
                "    \"name\":\""+student.getName()+"\",\n" +
                "    \"email\":\""+student.getEmail()+"\",\n" +
                "    \"mobile\":\""+student.getMobile()+"\"\n" +
                "}";
    }

    public String userToJsonList(List<Student> student){
        StringBuilder build =new StringBuilder();
        build.append("[");

        for (int i=0; i< student.size();i++){
            build.append(userToJson(student.get(i)));
            if (i < student.size()-1){
                build.append(",");
            }
        }

        build.append("]");
        return build.toString();
    }

}
