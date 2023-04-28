package com.miraouy.service;

import com.miraouy.ClientFeign.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servcie-etudiant")
public interface StudentService {
     @GetMapping("/{idStudent}?projection=student")
    public Student getStudent(@PathVariable Long idStudent);
}
