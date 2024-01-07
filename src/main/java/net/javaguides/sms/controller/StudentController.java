package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * the class StudentController
 *
 * @author apnan.juanda
 */
@Controller
public class StudentController {

    private StudentService studentService;

    private static final String STUDENTS = "students";
    private static final String CREATE_STUDENT = "createStudent";
    private static final String UPDATE_STUDENT = "updateStudent";

    private static final String REDIRECT = "redirect:/";

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    /**
     *
     * @param model the model
     * @return model and view to show page list students
     */
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return STUDENTS;
    }

    /**
     * this method to createStudentForm
     *
     * @param model the model
     * @return model and view to show page add new student
     */
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return CREATE_STUDENT;
    }

    /**
     * this method to saveStudent
     *
     * @param student   the student
     * @return page list students after save new student
     */
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("students") Student student) {
        studentService.saveStudent(student);
        return REDIRECT + STUDENTS;
    }

    /**
     * this method to editStudentForm
     *
     * @param model the model
     * @return model and view to show page update new student
     */
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return UPDATE_STUDENT;
    }

    /**
     * this method to updateStudent
     *
     * @param student   the student
     * @return page list students after update student
     */
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        final Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return REDIRECT + STUDENTS;
    }

    /**
     * this method to deleteStudent
     *
     * @param id    the id of student
     * @return page list students after delete student
     */
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return REDIRECT + STUDENTS;
    }
}
