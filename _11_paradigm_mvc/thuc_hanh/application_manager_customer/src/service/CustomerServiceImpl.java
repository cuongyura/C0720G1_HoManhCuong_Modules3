package service;

import models.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> listCustomers;
    static {
        listCustomers = new HashMap();
        listCustomers.put(1, new Customer(1,"Bé Anh","09875623025","Quảng trị"));
        listCustomers.put(2, new Customer(2,"Bé Ngân","03349984459","Huế"));
        listCustomers.put(3, new Customer(3,"Bé Trang","0130000890","Đà nẵng"));
        listCustomers.put(4, new Customer(4,"Bé Linh","02366115566","Mỹ Tho"));
    }

    @Override
    public List<Customer> getAllCustomer() {
        return new ArrayList<>(listCustomers.values());
    }

    @Override
    public void saveCustomer(Customer customer) {
        listCustomers.put(customer.getId(), customer);
    }

    @Override
    public void deleteCustomer(int id) {
        listCustomers.remove(id);
    }

    @Override
    public void editCustomer(int id, Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return listCustomers.get(id);
    }
}
