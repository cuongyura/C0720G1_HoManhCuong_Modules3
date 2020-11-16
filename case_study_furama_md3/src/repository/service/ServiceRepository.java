package repository.service;

import model.service.Service;

import java.util.List;

public interface ServiceRepository {
    void createService(Service service);
    List<Service> getAllService();
    void editService(Service service);
    void deleteService(int id);
    Service findById(int id);
    List<Service> searchServiceByName(String name);
}
