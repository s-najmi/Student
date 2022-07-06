package ir.mapsa.student;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {
}
