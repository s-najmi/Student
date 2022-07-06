package ir.mapsa.student.student;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v1")
@AllArgsConstructor
public class StudentController {
    private final IStudentService service;
    private final IStudentMapper mapper;

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return new ResponseEntity<>(mapper.toDTOs(service.getAll()), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<StudentDTO> AddNewStudent(@RequestBody StudentDTO studentDTO){
        Student student = mapper.toEntity(studentDTO);
        return new ResponseEntity<>(mapper.toDTO(service.save(student)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getByID(@PathVariable long id){
        return new ResponseEntity<>(mapper.toDTO(service.getByID(id)), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
        Student student = mapper.toEntity(studentDTO);
        return new ResponseEntity<>(mapper.toDTO(service.update(student)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
