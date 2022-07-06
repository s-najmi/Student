package ir.mapsa.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IStudentMapper {
    Student toEntity(StudentDTO studentDTO);
    @Mappings({
        @Mapping(source = "sample1" , target = ".", ignore = true),
        @Mapping(source = "sample2" , target = ".", ignore = true)
    })
    StudentDTO toDTO(Student student);
    List<StudentDTO> toDTOs(List<Student> students);
    List<Student> toEntities(List<StudentDTO> studentDTOS);
}
