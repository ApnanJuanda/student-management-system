package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * the class StudentServiceImpl
 *
 * @author apnan.juanda
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).isPresent() ?
                studentRepository.findById(id).get() : null;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * @{inheritDoc}
     */
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
