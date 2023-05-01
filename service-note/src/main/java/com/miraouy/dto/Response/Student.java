package com.miraouy.dto.Response;

import lombok.Data;

@Data
public class Student {
    private String apogee;
    private  String nom;
    private String prenom;
    private String cne;
    private ModuleF moduleF;
    private Filiere filiere;


}
