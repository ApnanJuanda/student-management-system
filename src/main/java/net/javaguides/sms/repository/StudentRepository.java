package net.javaguides.sms.repository;

import net.javaguides.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * the class StudentRepository
 *
 * @author apnan.juanda
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
