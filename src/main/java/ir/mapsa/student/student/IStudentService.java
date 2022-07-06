package ir.mapsa.student;

import java.util.List;

public interface IStudentService {
    Student save(Student student);
    Student update(Student student);
    List<Student> getAll();
    Student getByID(long id);
    void delete(long id);
}
