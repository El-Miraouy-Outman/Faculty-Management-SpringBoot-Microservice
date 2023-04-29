package com.miraouy.repository;

import com.miraouy.ClientFeign.Filiere;
import com.miraouy.ClientFeign.ModuleF;
import com.miraouy.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
    Note findByIdNote(Long idModule);
    //  Note findByIdStudentAndIdModule(Long idStudent, Long idModule);
 //   List<Note> findByModuleAndFiliere(ModuleF module, Filiere filiere);
   // List<Note> findByFiliere(Filiere filiere);


}

