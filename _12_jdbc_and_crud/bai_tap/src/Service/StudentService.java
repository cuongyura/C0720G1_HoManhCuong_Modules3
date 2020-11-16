package Service;

import models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAddStudent();
    void save(int id,Student student);
    Student findById(int id);
    void update( Student student);
    void remove(int id);
    void insert( Student student);

}
