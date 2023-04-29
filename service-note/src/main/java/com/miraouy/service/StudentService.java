package com.miraouy.service;

import com.miraouy.ClientFeign.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servcie-etudiant", path = "/api/", url = "${service.adherant.url}")
@Service
public interface StudentService {
     @GetMapping("/{idStudent}?projection=student")
     Student getStudent(@PathVariable Long idStudent);
}
