package net.javaguides.sms.service;

import net.javaguides.sms.entity.Student;

import java.util.List;

/**
 * the class StudentService
 *
 * @author apnan.juanda
 */
public interface StudentService {

    /**
     * this method to getAllStudents
     *
     * @return List of Student
     */
    List<Student> getAllStudents();

    /**
     * this method to saveStudent
     *
     * @param student   the student
     * @return Student
     */
    Student saveStudent(Student student);

    /**
     * this method to getStudentById
     *
     * @param id    the id of student
     * @return Student
     */
    Student getStudentById(Long id);

    /**
     * this method to updateStudent
     *
     * @param student   the student
     * @return  Student
     */
    Student updateStudent(Student student);

    /**
     * this method to deleteStudent
     *
     * @param id    the id of student
     */
    void deleteStudentById(Long id);
}
