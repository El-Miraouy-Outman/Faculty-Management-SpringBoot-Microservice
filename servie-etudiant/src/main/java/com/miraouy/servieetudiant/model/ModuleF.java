package com.miraouy.servieetudiant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "module")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name ;
@ManyToOne
@JoinColumn(name = "modules")

    private Filiere filiere;

}
