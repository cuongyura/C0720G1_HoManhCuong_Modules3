package service.customer;

import model.human.Customer;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.editCustomer(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return customerRepository.searchCustomerByName(name);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.createCustomer(customer);
    }
}
