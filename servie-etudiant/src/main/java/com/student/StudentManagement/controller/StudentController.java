package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.model.Carriere;
import com.student.StudentManagement.model.StudentPojo;
import com.student.StudentManagement.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public void SaveStudent(@RequestBody StudentPojo data) {
        studentService.saveStudent(data);

    }

    @GetMapping
    public List<RespenseStudentDto> viewStudents() {
        System.out.println("controller");
        return studentService.getAllStudents();

    }


    @GetMapping("/{apogee}")
    public RespenseStudentDto viewStudent(@PathVariable(value = "apogee") Long apogee) {
        return studentService.getStudentByApogee(apogee);

    }


    @DeleteMapping("/{apogee}")
    public void deleteStudent(@PathVariable(value = "apogee") Long apogee) {
        studentService.deleteStudent(apogee);
    }

    @GetMapping("/carrieres/{id}")
    public List<Carriere> getCarrieresByStudent(@PathVariable(name = "id") Long id) {
        return studentService.getCarrieresByStudentId(id);
    }
}
