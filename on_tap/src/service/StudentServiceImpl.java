package service;

import dao.IStudentDao;
import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private IStudentDao studentDao = new StudentDao();

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        return studentDao.searchStudentByName(name);
    }

    @Override
    public void delete(int id) {
         studentDao.delete(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.findStudentById(id);
    }

}
