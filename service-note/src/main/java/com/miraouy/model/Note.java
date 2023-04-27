package com.miraouy.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idNote;
    private Float note;
    private Long idStudent;

    @ManyToOne
    private ModuleF module;

    @ManyToOne
    private Filiere filiere;

}
