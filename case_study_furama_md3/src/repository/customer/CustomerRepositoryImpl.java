package repository.customer;

import model.human.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static repository.customer.DBConnection.getConnection;


public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + " (customer_id, customer_name, customer_birthday, customer_gender, " +
            "customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ? ,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?;";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, " +
            "customer_phone = ?, customer_email = ?, customer_address = ?, customer_type_id = ? where customer_id = ?;";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String SEARCH_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?;";

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("customer_id");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender;
                if (rs.getInt("customer_gender") == 0) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                String idCard = rs.getString("customer_id_card");
                String phoneNumb = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                String typeCustomer = null;
                if (rs.getInt("customer_type_id") == 1) {
                    typeCustomer = "Diamond";
                } else if (rs.getInt("customer_type_id") == 2){
                    typeCustomer = "Platinum";
                } else if(rs.getInt("customer_type_id") == 3){
                    typeCustomer = "Gold";
                }else if(rs.getInt("customer_type_id") == 4){
                    typeCustomer = "Silver";
                }else if(rs.getInt("customer_type_id") == 5){
                    typeCustomer = "Member";
                } else {
                    typeCustomer = "Unknown";
                }
                customers.add(new Customer(id, name, birthday, gender, idCard, phoneNumb, email, address, typeCustomer));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return customers;
    }

    @Override
    public void editCustomer(Customer customer) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)){
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getDateOfBirth());
            preparedStatement.setInt(3, Integer.parseInt(customer.getGender()));
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhoneNumb());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, Integer.parseInt(customer.getTypeCustomer()));
            preparedStatement.setInt(9, customer.getIdCustomer());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }


    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phoneNumb = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                String typeCustomer = rs.getString("customer_type_id");
                customer = new Customer(id, name, birthday, gender, idCard, phoneNumb, email, address, typeCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME)){
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("customer_id");
                String name1 = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phoneNumb = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                String typeCustomer = rs.getString("customer_type_id");
                customerList.add(new Customer(id, name1, birthday, gender, idCard, phoneNumb, email, address, typeCustomer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) {
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)){
            preparedStatement.setInt(1, customer.getIdCustomer());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getDateOfBirth());
            preparedStatement.setInt(4, Integer.parseInt(customer.getGender()));
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhoneNumb());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, Integer.parseInt(customer.getTypeCustomer()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }
}


