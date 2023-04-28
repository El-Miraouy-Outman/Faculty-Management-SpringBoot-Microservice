package com.miraouy.servieetudiant.service;

import com.miraouy.servieetudiant.models.Student;

import java.util.List;

public interface StudentService {
    public Student getStudent(Long idStudent);
    public Student addStudent(Student student);
    public Student updateStudent(Long student);

    public Student deleteStudent(Long idstudent);
    public List<Student> allStudent();

}
