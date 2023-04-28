package com.miraouy.servieetudiant.service;

import com.miraouy.servieetudiant.models.Student;
import com.miraouy.servieetudiant.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Long idStudent) {
        return studentRepository.findById(idStudent).get();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long student) {
        return null;
    }

    @Override
    public Student deleteStudent(Long idstudent) {
        return null;
    }

    @Override
    public List<Student> allStudent() {
        return studentRepository.findAll();
    }
}
