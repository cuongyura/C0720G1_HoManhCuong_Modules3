package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = " ";
        }
        switch (action){
            case "delete":
//                deleteCustomer(request,response);
                break;
            case "edit":
                editStudent(request,response);
                break;
            case "add":
                addStudent(request,response);
                getAllStudent(request,response);
                break;
        
            default:
                getAllStudent(request,response);
        }

    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String phone=request.getParameter("phone");
        studentService.updateStudent(new Student(id,name,gender,phone));
        getAllStudent(request,response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String phone=request.getParameter("phone");
        Student student=new Student(name,gender,phone);
        studentService.create(student);
        getAllStudent(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = " ";
        }
        switch (action){
            case "delete":
              deleteStudent(request,response);
                break;
            case "edit":
                showEditStudent(request,response);
                break;
            case "add":
                addStudentform(request,response);
                break;
            case "search":
                searchStudentByName(request,response);
                break;
            default:
                getAllStudent(request,response);
        }
    }

    private void showEditStudent(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("studentId"));
        Student student = studentService.findStudentById(id);
        request.setAttribute("student",student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
         int id = Integer.parseInt(request.getParameter("studentId"));
         studentService.delete(id);
         getAllStudent(request, response);

    }

    private void searchStudentByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Student> studentList = studentService.searchStudentByName(name);
        request.setAttribute("getAll", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStudentform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        response.sendRedirect("/add.jsp");
    }

    private void getAllStudent(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("getAll", studentService.getAllStudent());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
