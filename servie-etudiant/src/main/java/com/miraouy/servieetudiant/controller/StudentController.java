package com.miraouy.servieetudiant.controller;


import com.miraouy.servieetudiant.dto.RequestStudentDto;
import com.miraouy.servieetudiant.dto.RespenseStudentDto;
import com.miraouy.servieetudiant.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController  {
    private final StudentService studentService ;
   @GetMapping("/{apogee}")
    public RespenseStudentDto getStudentByApogee(@PathVariable(name = "apogee") String apogee) {
        return studentService.getStudentByApogee(apogee);
    }


}
