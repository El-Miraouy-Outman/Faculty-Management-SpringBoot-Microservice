package com.miraouy.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModuleF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;
    private  String name;
    @ManyToMany(mappedBy = "modules")
   private List<Filiere> filieres;
    @OneToMany(mappedBy = "module")
    private  List<Note> notes;
}
