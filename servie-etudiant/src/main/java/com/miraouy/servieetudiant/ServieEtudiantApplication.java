package com.miraouy.servieetudiant;

import com.miraouy.servieetudiant.models.Student;
import com.miraouy.servieetudiant.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
public class ServieEtudiantApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServieEtudiantApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(StudentService service){

        return args -> {
            Student student0=Student.builder().name("outman").prenom("el miraouy").age(22).build();
            Student student1=Student.builder().name("said").prenom("fadili").age(22).build();
            Student student2=Student.builder().name("mohsine").prenom("hajar").age(22).build();
            Student student3=Student.builder().name("mohmad").prenom("khayati").age(22).build();
            service.addStudent(student0);
            service.addStudent(student1);
            service.addStudent(student2);
            service.addStudent(student3);

        };
    }
}
