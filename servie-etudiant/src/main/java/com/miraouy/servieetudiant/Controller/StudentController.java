package com.miraouy.servieetudiant.Controller;

import com.miraouy.servieetudiant.models.Student;
import com.miraouy.servieetudiant.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{idstudent}")
    public Student updateStudent(Long idstudent) {
        return studentService.updateStudent(idstudent);
    }

    @DeleteMapping("/{idstudent}")
    public Student deleteStudent(@PathVariable Long idstudent) {
        return studentService.deleteStudent(idstudent);
    }

    @GetMapping
    public List<Student> allStudent() {
        return studentService.allStudent();
    }

    @GetMapping("/{idStudent}?projection=student")
    public Student getStudent(@PathVariable Long idStudent) {
        return studentService.getStudent(idStudent);
    }
}