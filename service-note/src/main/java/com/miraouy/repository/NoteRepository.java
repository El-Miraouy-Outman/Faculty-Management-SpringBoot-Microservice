package com.miraouy.repository;

import com.miraouy.ClientFeign.Filiere;
import com.miraouy.ClientFeign.ModuleF;
import com.miraouy.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findByIdStudent(Long isStudent);
    Note findByI(Long isStudent);

    List<Note> findByModuleAndFiliere(ModuleF module, Filiere filiere);
    List<Note> findByFiliere(Filiere filiere);

}

