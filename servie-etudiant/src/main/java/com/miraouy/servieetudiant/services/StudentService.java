package com.miraouy.servieetudiant.services;

import com.miraouy.servieetudiant.dto.RequestStudentDto;
import com.miraouy.servieetudiant.dto.RespenseStudentDto;
import com.miraouy.servieetudiant.model.Student;

import java.util.List;

public interface StudentService {
    RespenseStudentDto createStudent(RequestStudentDto student);

    List<RespenseStudentDto> getAllStudents();
    RespenseStudentDto getStudentByApogee(String apogee);

    RespenseStudentDto updateStudent(RequestStudentDto student);

    RespenseStudentDto deleteStudent(String cin);
}
