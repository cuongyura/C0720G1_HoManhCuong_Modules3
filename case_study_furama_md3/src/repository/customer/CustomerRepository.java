package repository.customer;

import model.human.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomer();
    void editCustomer(Customer customer);
    Customer findById(int id);
    void deleteCustomer(int id);
    List<Customer> searchCustomerByName(String name);
    void createCustomer(Customer customer);

}
