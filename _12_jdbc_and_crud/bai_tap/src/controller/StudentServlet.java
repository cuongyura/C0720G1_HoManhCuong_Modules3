package controller;

import Service.StudentService;
import Service.StudentServiceImpl;
import models.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {

    // create object :
    private StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = " ";
        }
        switch (action){
            case "create":
                saveStudent(request, response);
                break;
            case "edit":
                saveStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    private void saveStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Student student = new Student(id, name, dayOfBirth, address, email);
        studentService.insert(student);
        listStudents(request,response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentService.getAddStudent();
        System.out.println(students);
        request.setAttribute("students", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = " ";
        }
        switch (action){
            case "create":
                insertStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student =  studentService.findById(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.remove(id);
        try {
            response.sendRedirect("/students");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
