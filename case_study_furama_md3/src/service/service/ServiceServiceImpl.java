package service.service;

import model.service.Service;
import repository.service.ServiceRepository;
import repository.service.ServiceRepositoryImpl;

import java.util.List;

public class ServiceServiceImpl implements ServiceService{
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public void createService(Service service) {
        serviceRepository.createService(service);
    }

    @Override
    public List<Service> getAllService() {
        return serviceRepository.getAllService();
    }

    @Override
    public void editService(Service service) {
        serviceRepository.editService(service);
    }

    @Override
    public void deleteService(int id) {
        serviceRepository.deleteService(id);
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Service> searchServiceByName(String name) {
        return serviceRepository.searchServiceByName(name);
    }
}
