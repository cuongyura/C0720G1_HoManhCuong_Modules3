package service.employee;

import model.customer.Customer;
import model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    void editEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee findById(int id);
    List<Employee> searchEmployeeByName(String name);
}
