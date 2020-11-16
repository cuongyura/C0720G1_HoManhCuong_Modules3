package repository;

import models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentRepositoryImpl implements StudentRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "nqnhmc12";

    private static final String INSERT_STUDENTS_SQL = "INSERT INTO students" + "  (name, dayOfBirth,address,email) VALUES " +
            " (?, ?, ?, ?);";

    private static final String SELECT_STUDENT_BY_ID = "select id, name, dayOfBirth, address, email from students where id =?";
    private static final String SELECT_ALL_STUDENTS = "select * from students";
    private static final String DELETE_STUDENTS_SQL = "delete from students where id = ?;";
        private static final String UPDATE_STUDENTS_SQL = "update students set name = ?,dayOfBirth = ?,address = ?,email= ? where id = ;";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Student> getAddStudent() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Student> students = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dayOfBirth = rs.getString("dayOfBirth");
                String address = rs.getString("address");
                String email = rs.getString("email");
                students.add(new Student(id, name, dayOfBirth, address, email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Student findById(int id) {
        Student student = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String dayOfBirth = rs.getString("dayOfBirth");
                String address = rs.getString("address");
                String email = rs.getString("email");
                student = new Student(id, name, dayOfBirth, address, email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    @Override
    public void update( Student student){
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
                statement.setString(1, student.getName());
                statement.setString(2, student.getDayOfBirth());
                statement.setString(3, student.getAddress());
                statement.setString(4, student.getEmail());
                statement.setInt(5,student.getId());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


    }

    @Override
    public void insert(Student student) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_STUDENTS_SQL);) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getDayOfBirth());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getEmail());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean remove(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }


}
