package com.student.StudentManagement.dto;

import com.student.StudentManagement.enumurations.Diplomat;
import com.student.StudentManagement.enumurations.Gender;
import com.student.StudentManagement.model.Carriere;
import com.student.StudentManagement.model.Filiere;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class RespenseStudentDto {
   // private String cin ;
    private long apogee;
    private String nom ;
    private String prenom ;
    private String cne ;
   // private String email ;
    private Gender genre ;
    private RespenseFiliereDto filiere;
    //private List<Carriere> carriere;
    //private RespenseFiliereDto filiere;
    //private RespenseModuleFDto module;
}
