package dao;

import model.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> getAllStudent();
   void create(Student student);
   List<Student> searchStudentByName(String name);
    void delete(int id);
    boolean updateStudent(Student student);
    Student findStudentById(int id);


}
