package repository.employee;

import model.customer.Customer;
import model.employee.Employee;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static repository.DBConnection.getConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + " (employee_id, employee_name, employee_birthday, employee_id_card, " +
            "employee_phone, employee_salary, employee_email, employee_address, position_id, education_degree_id, division_id, username) " +
            "VALUES " + " (?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,?);";

    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?;";
    private static final String SELECT_ALL_EMPLOYEE = "select employee_id, employee_name, employee_birthday, employee_id_card, employee_phone, employee_salary, employee_email, employee_address, \n" +
            "position_name, education_degree_name, division_name, user.username from employee \n" +
            "join positions on employee.position_id = positions.position_id \n" +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id \n" +
            "join division on employee.division_id = division.division_id \n" +
            "join user on employee.username = user.username;";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_phone = ?, " +
            "employee_salary = ?, employee_email = ?, employee_address = ?, employee.position_id = ?, employee.education_degree_id = ?, employee.division_id = ?, employee.username = ? where employee_id = ?;";
    private static final String SEARCH_EMPLOYEE_BY_NAME = "select * from employee where employee_name like ?;";

    @Override
    public void createEmployee(Employee employee) {
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)){
            preparedStatement.setInt(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getDateOfBirth());
            preparedStatement.setString(4, employee.getIdCard());
            preparedStatement.setString(5, employee.getEmployeePhoneNumb());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setString(7, employee.getEmployeeEmail());
            preparedStatement.setString(8, employee.getEmployeeAddress());
            preparedStatement.setInt(9, Integer.parseInt(employee.getPosition_id()));
            preparedStatement.setInt(10, Integer.parseInt(employee.getEducation_id()));
            preparedStatement.setInt(11, Integer.parseInt(employee.getDivision_id()));
            preparedStatement.setString(12, employee.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String dateOfBirth = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                String phoneNumb = rs.getString("employee_phone");
                Double salary = rs.getDouble("employee_salary");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                String position = rs.getString("position_name");
                String education = rs.getString("education_degree_name");
                String division = rs.getString("division_name");
                String userName = rs.getString("username");
                employees.add(new Employee(id, name, dateOfBirth, idCard, phoneNumb, salary, email, address, position, education, division, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return employees;
    }

    @Override
    public void editEmployee(Employee employee) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)){
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, employee.getEmployeePhoneNumb());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, Integer.parseInt(employee.getPosition_id()));
            preparedStatement.setInt(9, Integer.parseInt(employee.getEducation_id()));
            preparedStatement.setInt(10, Integer.parseInt(employee.getDivision_id()));
            preparedStatement.setString(11, employee.getUserName());
            preparedStatement.setInt(12, employee.getEmployee_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("employee_name");
                String dateOfBirth = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                String phoneNumb = rs.getString("employee_phone");
                Double salary = rs.getDouble("employee_salary");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                String position = rs.getString("position_id");
                String education = rs.getString("education_degree_id");
                String division = rs.getString("division_id");
                String userName = rs.getString("username");
                employee = new Employee(id, name, dateOfBirth, idCard, phoneNumb, salary, email, address, position, education, division, userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return employee;
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME)){
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("employee_id");
                String name1 = rs.getString("employee_name");
                String dateOfBirth = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                String phoneNumb = rs.getString("employee_phone");
                Double salary = rs.getDouble("employee_salary");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                String position = rs.getString("position_id");
                String education = rs.getString("education_degree_id");
                String division = rs.getString("division_id");
                String userName = rs.getString("username");
                employeeList.add(new Employee(id, name1, dateOfBirth, idCard, phoneNumb, salary, email, address, position, education, division, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return employeeList;
    }
}
