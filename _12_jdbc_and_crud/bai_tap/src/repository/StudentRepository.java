package repository;

import models.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAddStudent();
    void save(Student student);
    Student findById(int id);
    void update(Student student);
    void insert(Student student);
    boolean remove(int id);
}
