package com.miraouy.ClientFeign;

import lombok.Data;

@Data
public class Student {
    private String apogee;
    private  String name;
    private String prenom;
    private ModuleF module;
    private Filiere filiere;


}
