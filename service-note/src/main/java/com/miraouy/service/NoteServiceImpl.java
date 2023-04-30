package com.miraouy.service;

import com.miraouy.ClientFeign.FiliereClient;
import com.miraouy.ClientFeign.ModuleClient;
import com.miraouy.ClientFeign.StudentClient;
import com.miraouy.Exception.Filiere.FiliereNotFound;
import com.miraouy.Exception.ModuleF.ModuleNotFound;
import com.miraouy.Exception.Note.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.Filiere;
import com.miraouy.dto.Response.ModuleF;
import com.miraouy.dto.Response.NoteResponseDto;
import com.miraouy.dto.Response.Student;
import com.miraouy.model.Note;
import com.miraouy.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;
    private final StudentClient studentClient ;
    private final ModuleClient moduleClient;
    private final FiliereClient filiereClient;


    public NoteServiceImpl(NoteRepository noteRepository, StudentClient studentClient, ModuleClient moduleClient, FiliereClient filiereClient) {
        this.noteRepository = noteRepository;
        this.studentClient = studentClient;
        this.moduleClient = moduleClient;
        this.filiereClient = filiereClient;
    }

    @Override
    public NoteResponseDto addNote(NoteRequestDto noteRequestDto) {
        ModuleF module=moduleClient.viewModule(noteRequestDto.getIdModule());
        System.out.println(module);
        System.out.println("helloooo****");
        Note note=Note.builder()
                .note(noteRequestDto.getNote())
                //.module(module)
               // .idStudent(noteRequestDto.getIdStudent())
                .build();
        Note noteSave=noteRepository.save(note);
        System.out.println("hello 2");
        // traitement pour chercher l'etudiant apres la construction de l'autre microservice

        return NoteResponseDto.builder()
                .note(noteSave.getNote())
                // .student()
                .build();
    }

    @Override
    public NoteResponseDto findNoteByStudentAndModule(Long idStudent, Long idModule) throws NoteNotFound {
        Optional<Note> note = noteRepository.findByidStudentAndIdModule(idStudent,idModule);
        Student student = studentClient.getStudent(idStudent);
        ModuleF moduleF = moduleClient.viewModule(idModule);
        Filiere filiere = filiereClient.viewFiliere(student.getFilier().getId());
        student.setModuleF(moduleF);
        student.setFilier(filiere);
       NoteResponseDto noteResponseDto=NoteResponseDto
               .builder()
               .note(note.get().getNote())
               .student(student)
               .build();
        return noteResponseDto;
    }

    @Override
    public List<NoteResponseDto> findNotesEtudiant(Long idStudent) {
        //get the student info
        //get the filiere of the student
        //get modules Ids
        //for each module find note by idStudentAndidModules
        //store notes in a List of NoteResponse and return it
        return null;
    }

    @Override
    public List<NoteResponseDto> findNoteFiliereAndModule(Long idFiliere, Long idModule) throws FiliereNotFound, ModuleNotFound {
       // Filiere filiere = filiereRepository.findById(idFiliere).orElseThrow(() -> new FiliereNotFound("Filiere not found"));
      //  ModuleF module = moduleRepository.findById(idModule).orElseThrow(() -> new ModuleNotFound("Module not found"));
      //  List<Note> notes = noteRepository.findByModuleAndFiliere(module, filiere);
        return null;//notes.stream().map(note -> new NoteResponseDto(note.getNote(), note.getIdStudent())).collect(Collectors.toList());
    }


    @Override
    public NoteResponseDto deleteNote(Long idStudent,Long idModule) throws NoteNotFound {
        return null;
    }

    @Override
    public NoteResponseDto updaeNote(Long id,Long idModule) throws NoteNotFound {
        return null;
    }
}
