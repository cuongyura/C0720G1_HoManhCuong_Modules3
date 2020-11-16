package service.employee;

import model.customer.Customer;
import model.employee.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.createEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return employeeRepository.searchEmployeeByName(name);
    }
}
