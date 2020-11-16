package controller;

import model.human.Customer;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                searchCustomerByName(request,response);
                break;
            default:
                getAllCustomer(request,response);
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("customer_id");
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("customer_id_card");
        String phoneNumb = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        String typeCustomer = request.getParameter("customer_type_id");
        Customer customer = new Customer(Integer.parseInt(id), name, birthday, gender, idCard, phoneNumb, email,  typeCustomer, address);
        customerService.createCustomer(customer);
        getAllCustomer(request,response);
    }



    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = customerService.searchCustomerByName(name);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customer_id"));
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("customer_id_card");
        String phoneNumb = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        String typeCustomer = request.getParameter("customer_type_id");
        Customer customer = new Customer(id, name, birthday, gender, idCard, phoneNumb, email, address, typeCustomer);
        customerService.editCustomer(customer);
        getAllCustomer(request,response);
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
                createJSP(request, response);
                break;
            case "edit":
                editJsp(request, response);
                break;
            case "delete":
                deleteCustomerById(request,response);
                break;
            default:
                getAllCustomer(request,response);
        }
    }

    private void createJSP(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/add.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomerById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        customerService.deleteCustomer(id);
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editJsp(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void getAllCustomer(HttpServletRequest request, HttpServletResponse response){
       List<Customer> customerList = customerService.getAllCustomer();
       request.setAttribute("customerList",customerList);
       RequestDispatcher dispatcher = request.getRequestDispatcher("customer/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
