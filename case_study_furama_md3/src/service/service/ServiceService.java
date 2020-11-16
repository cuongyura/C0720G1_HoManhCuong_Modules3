package service.service;

import model.employee.Employee;
import model.service.Service;

import java.util.List;

public interface ServiceService {
    void createService(Service service);
    List<Service> getAllService();
    void editService(Service service);
    void deleteService(int id);
    Service findById(int id);
    List<Service> searchServiceByName(String name);
}
