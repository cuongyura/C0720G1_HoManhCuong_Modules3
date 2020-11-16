package Service;

import models.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> getAddStudent() {
        return studentRepository.getAddStudent();
    }

    @Override
    public void save(int id,Student student) {
//        studentRepository.update(id, student);

    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update( Student student) {
        studentRepository.update(student);
    }

    @Override
    public void remove(int id) {
        studentRepository.remove(id);

    }

    @Override
    public void insert(Student student) {
        studentRepository.insert(student);
    }


}
