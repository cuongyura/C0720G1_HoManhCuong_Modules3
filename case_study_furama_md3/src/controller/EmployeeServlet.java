package controller;

import model.customer.Customer;
import model.employee.Employee;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
            default:
                getAllEmployee(request,response);
        }
    }

    private void getAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Employee> employeeList = employeeService.searchEmployeeByName(name);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        String phoneNumb = request.getParameter("phoneNumb");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String education = request.getParameter("education");
        String division = request.getParameter("division");
        String userName = request.getParameter("userName");
        String salary = request.getParameter("salary");
        Employee employee = new Employee(id, name, dateOfBirth, idCard, phoneNumb, Double.parseDouble(salary), email, address, position, education, division, userName);
        employeeService.editEmployee(employee);
        getAllEmployee(request,response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        String phoneNumb = request.getParameter("phoneNumb");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String education = request.getParameter("education");
        String division = request.getParameter("division");
        String userName = request.getParameter("userName");
        String salary = request.getParameter("salary");
        Employee employee = new Employee(Integer.parseInt(id), name, dateOfBirth, idCard, phoneNumb, Double.parseDouble(salary), email, address, position,
                education, division, userName);
        employeeService.createEmployee(employee);
        getAllEmployee(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                break;
            case "edit":
                editJsp(request,response);
                break;
            case "delete":
                deleteEmployeeById(request,response);
                break;
            case "search":
                searchEmployeeByName(request,response);
                break;
            default:
                getAllEmployee(request,response);
        }
    }

    private void deleteEmployeeById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void editJsp(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
