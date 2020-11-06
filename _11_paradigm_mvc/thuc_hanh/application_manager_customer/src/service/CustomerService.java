package service;

import models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    void saveCustomer(Customer customer);
    void deleteCustomer(int id);
    void editCustomer(int id, Customer customer);
    Customer findById(int id);
}
