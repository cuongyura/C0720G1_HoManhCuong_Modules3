package service.customer;

import model.human.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    void editCustomer(Customer customer);
    Customer findById(int id);
    void deleteCustomer(int id);
    List<Customer> searchCustomerByName(String name);
    void createCustomer(Customer customer);
}
