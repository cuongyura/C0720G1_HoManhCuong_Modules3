package repository.service;

import model.service.Service;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository{
    private static final String INSERT_SERVICE_SQL = "insert into service(service_id, service_name, service_area, service_cost, service_max_people, standard_room, \n" +
            "description, pool_area, number_of_floor, service.service_type_id, service.rent_type_id) \n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_SERVICE_BY_ID = "select * from employee where employee_id = ?;";
    private static final String SELECT_ALL_SERVICE = "select service_id, service_name, service_area, service_cost, service_max_people, standard_room, \n" +
            "description, pool_area, number_of_floor, service_type.service_type_name, rent_type.rent_type_name from service \n" +
            "join service_type on service_type.service_type_id = service.service_type_id \n" +
            "join rent_type on rent_type.rent_type_id = service.rent_type_id;";
    private static final String DELETE_SERVICE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_SERVICE_SQL = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_phone = ?, " +
            "employee_salary = ?, employee_email = ?, employee_address = ?, employee.position_id = ?, employee.education_degree_id = ?, employee.division_id = ?, employee.username = ? where employee_id = ?;";
    private static final String SEARCH_SERVICE_BY_NAME = "select * from employee where employee_name like ?;";
    @Override
    public void createService(Service service) {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)){
            preparedStatement.setInt(1, service.getServiceId());
            preparedStatement.setString(2, service.getServiceName());
            preparedStatement.setDouble(3, service.getServiceArea());
            preparedStatement.setDouble(4, service.getServiceCost());
            preparedStatement.setInt(5, service.getServiceMaxPeople());
            preparedStatement.setString(6, service.getStandardRoom());
            preparedStatement.setString(7, service.getDescription());
            preparedStatement.setDouble(8, service.getPoolArea());
            preparedStatement.setInt(9, service.getNumbFloor());
            preparedStatement.setInt(10, Integer.parseInt(service.getServiceType()));
            preparedStatement.setInt(11, Integer.parseInt(service.getRentType()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Service> getAllService() {
        List<Service> serviceList = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                double serviceArea = rs.getDouble("service_area");
                double cost = rs.getDouble("service_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description");
                double poolArea = rs.getDouble("pool_area");
                int numbFloor = rs.getInt("number_of_floor");
                String serviceTypeName = rs.getString("service_type_name");
                String serviceRentType = rs.getString("rent_type_name");
                serviceList.add(new Service(id, name, serviceArea, cost, serviceMaxPeople, standardRoom, description,
                        poolArea, numbFloor, serviceTypeName, serviceRentType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return serviceList;
    }

    @Override
    public void editService(Service service) {

    }

    @Override
    public void deleteService(int id) {

    }

    @Override
    public Service findById(int id) {
        return null;
    }

    @Override
    public List<Service> searchServiceByName(String name) {
        return null;
    }
}
