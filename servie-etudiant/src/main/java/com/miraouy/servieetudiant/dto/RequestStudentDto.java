package com.miraouy.servieetudiant.dto;


import com.miraouy.servieetudiant.enumurations.Diplomat;
import com.miraouy.servieetudiant.enumurations.Gender;
import com.miraouy.servieetudiant.model.Filiere;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class RequestStudentDto {
    private String cin ;
    private String apogee;
    private String nom ;
    private String prenom ;
    private String cne ;
    private String email ;
    private String phone;
    private Date dateNaissance ;
    private String lieuNaissance ;
    private String adresse ;
    private Gender genre ;
    private Diplomat diplomat;
    private List<Filiere> filieres;

}
