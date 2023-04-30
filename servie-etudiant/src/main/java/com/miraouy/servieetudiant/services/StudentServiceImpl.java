package com.miraouy.servieetudiant.services;

import com.miraouy.servieetudiant.dto.RequestStudentDto;
import com.miraouy.servieetudiant.dto.RespenseStudentDto;
import com.miraouy.servieetudiant.model.Student;
import com.miraouy.servieetudiant.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository ;
    @Override
    public RespenseStudentDto createStudent(RequestStudentDto student) {
        RequestStudentDto dto = RequestStudentDto.builder().build();
        Student student1= new Student();
        BeanUtils.copyProperties(student, student1);
        Student storedStudent  = studentRepository.save(student1);
        BeanUtils.copyProperties(storedStudent, dto);
        return null;
    }

    @Override
    public List<RespenseStudentDto> getAllStudents() {
        return null;
    }

    @Override
    public RespenseStudentDto getStudentByApogee(String apogee) {
        Student student=studentRepository.getStudentByApogee(apogee);
        RespenseStudentDto response=RespenseStudentDto.builder()
                .apogee(student.getApogee())
                .cne(student.getCne())
                .nom(student.getNom())
                .prenom(student.getPrenom())
                .build();
        return response;
    }

    @Override
    public RespenseStudentDto updateStudent(RequestStudentDto student) {
   return null;
    }

    @Override
    public RespenseStudentDto deleteStudent(String cin) {
       return null;
    }
}
