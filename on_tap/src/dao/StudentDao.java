package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao{
    String jdbcURL = "jdbc:mysql://localhost:3306/class";
    private String jdbcCustomername = "root";
    private String jdbcPassword = "12345678";
    private final String SHOW_ALL_STUDENT = "select * from student;";
    private final String CREATE_STUDENT="insert into student(name , gender, phoneNumber) values(?,?,?);";
    private final String SEARCH_STUDENT="select * from student where name like ?;";
    private final String DELETE_STUDENT = "delete from student where id = ?";
    private final String UPDATE_STUDENT = "update student set name=?,gender=?,phoneNumber=? where id =?";
    private final String SELECT_STUDENT_BY_ID = "select * from student where id =?";
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcCustomername,jdbcPassword);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    protected void closeConnection(){
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SHOW_ALL_STUDENT)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender =rs.getString("gender");
                String phoneNumber = rs.getString("phoneNumber");
                Student student = new Student(id,name,gender,phoneNumber);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return students;
    }

    @Override
    public void create(Student student) {
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(CREATE_STUDENT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getGender());
            preparedStatement.setString(3,student.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean check = false;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT)) {
            statement.setString(1,student.getName());
            statement.setString(2,student.getGender());
            statement.setString(3,student.getPhoneNumber());
            statement.setInt(4,student.getId());
            check = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            statement.setInt(1,id);
            ResultSet rs =  statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String gender =rs.getString("gender");
                String phoneNumber = rs.getString("phoneNumber");
                student = new Student(id,name,gender,phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        List<Student> students = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENT)){
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String gender =rs.getString("gender");
                String phoneNumber = rs.getString("phoneNumber");
                Student student = new Student(id,name1,gender,phoneNumber);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }



}
