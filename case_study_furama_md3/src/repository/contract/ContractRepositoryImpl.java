package repository.contract;

import model.contract.Contract;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private static final String INSERT_CONTRACT_SQL = "insert into contract(contract.contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, contract.customer_id, contract.employee_id, contract.service_id) \n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_CONTRACT_SQL = "select contract.contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, customer.customer_name, employee.employee_name, service.service_name \n" +
            "from contract \n" +
            "join customer on customer.customer_id = contract.customer_id \n" +
            "join employee on employee.employee_id = contract.employee_id \n" +
            "join service on service.service_id = contract.contract_id;";
    @Override
    public void createContract(Contract contract) {
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL)){
            preparedStatement.setInt(1, Integer.parseInt(contract.getContractId()));
            preparedStatement.setString(2, contract.getDateStart());
            preparedStatement.setString(3, contract.getDateEnd());
            preparedStatement.setDouble(4, contract.getDeposit());
            preparedStatement.setDouble(5, contract.getTotal());
            preparedStatement.setInt(6, Integer.parseInt(contract.getCustomerId()));
            preparedStatement.setInt(7, Integer.parseInt(contract.getEmployeeId()));
            preparedStatement.setInt(8, Integer.parseInt(contract.getServiceId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public List<Contract> getAllContract() {
        List<Contract> contracts = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_SQL)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = "MHD-" + rs.getInt("contract_id");
                String dateStar = rs.getString("contract_start_date");
                String dateEnd = rs.getString("contract_end_date");
                Double deposit = rs.getDouble("contract_deposit");
                Double total = rs.getDouble("contract_total_money");
                String customerId = rs.getString("customer_name");
                String employeeId = rs.getString("employee_name");
                String serviceId = rs.getString("service_name");
                contracts.add(new Contract(id, dateStar, dateEnd, deposit, total, customerId, employeeId, serviceId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return contracts;
    }
}
