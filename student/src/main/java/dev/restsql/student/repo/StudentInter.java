package dev.restsql.student.repo;

import dev.restsql.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInter extends JpaRepository<Student, Long>
{

}
