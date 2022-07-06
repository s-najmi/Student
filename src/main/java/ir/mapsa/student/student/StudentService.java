package ir.mapsa.student.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{
    private final IStudentRepository repository;

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        Student newStudent = getByID(student.getId());
        newStudent.setName(student.getName());
        newStudent.setFamily(student.getFamily());
        newStudent.setPicture(student.getPicture());
        newStudent.setBirthDate(student.getBirthDate());
        newStudent.setNationalCode(student.getNationalCode());
        return repository.save(newStudent);
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student getByID(long id) {
        Optional<Student> opt = repository.findById(id);
        if (opt.isEmpty())
                throw new RuntimeException();
        return opt.get();
    }

    @Override
    public void delete(long id) {
        getByID(id);
        repository.deleteById(id);
    }
}
