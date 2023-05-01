package com.miraouy.servieetudiant.model;

import com.miraouy.servieetudiant.enumurations.Diplomat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "carriere")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carriere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Diplomat diplomat;

    @ManyToMany
    private List<Student> student;


}
