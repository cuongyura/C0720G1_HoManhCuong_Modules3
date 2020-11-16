package controller;

import model.service.Service;
import repository.service.ServiceRepositoryImpl;
import service.service.ServiceService;
import service.service.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private ServiceService serviceService = new ServiceServiceImpl();
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
                editCustomer(request,response);
                break;
            default:
                getAllService(request,response);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double svArea = Double.parseDouble(request.getParameter("serviceArea"));
        double svCost = Double.parseDouble(request.getParameter("serviceCost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numbFloor = Integer.parseInt(request.getParameter("numbFloor"));
        String svType = request.getParameter("svType");
        String rentType = request.getParameter("rentType");
        Service service = new Service(id, name, svArea, svCost, maxPeople, standardRoom, description, poolArea, numbFloor, svType, rentType);
        serviceService.createService(service);
        getAllService(request,response);
    }

    private void getAllService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.getAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                break;
            default:
                getAllService(request,response);
        }
    }
}
