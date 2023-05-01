package com.miraouy.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
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
import org.springframework.beans.BeanUtils;
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
        Note findNote=noteRepository.findByApogeeAndIdModule(noteRequestDto.getApogee(),noteRequestDto.getIdModule()).orElse(null);
        if(findNote!=null) {
            System.out.println("note exist deja");
            return null;
        }
        ModuleF module=moduleClient.viewModule(noteRequestDto.getIdModule());
        System.out.println(module);
        System.out.println("helloooo****");
        Student student=studentClient.getStudent(noteRequestDto.getApogee());
        System.out.println(student);
        Note note=Note.builder()
                .note(noteRequestDto.getNote())
                .apogee(noteRequestDto.getApogee())
                .idModule(noteRequestDto.getIdModule())
                .build();
        System.out.println(note);
        Note noteSave=noteRepository.save(note);
        System.out.println("hello 2");
        // traitement pour chercher l'etudiant apres la construction de l'autre microservice
        NoteResponseDto noteResponseDto=NoteResponseDto
                .builder()
                .note(note.getNote())
                .student(student)
                .build();
        return noteResponseDto;
    }

    @Override
    public Note findNote(Long apogee, Long IDMODULE) {

      Note note=  noteRepository.findByApogeeAndIdModule(apogee, IDMODULE).get();
       System.out.println(note);
       return note;
    }

    @Override
    public NoteResponseDto findNoteByStudentAndModule(Long apogee, Long idModule) throws NoteNotFound {
        Optional<Note> note = noteRepository.findByApogeeAndIdModule(apogee,idModule);
        System.out.println(note);
        Student student = studentClient.getStudent(apogee);
        System.out.println(student.toString());
        ModuleF moduleF = moduleClient.viewModule(idModule);
        System.out.println(moduleF.toString());
        Filiere filiere = filiereClient.viewFiliere(student.getFiliere().getId());
        student.setModuleF(moduleF);
        student.setFiliere(filiere);
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
    public NoteResponseDto deleteNote(Long apogee,Long idModule) throws NoteNotFound {
        return null;
    }

    @Override
    public NoteResponseDto updaeNote(Long apogee,Long idModule) throws NoteNotFound {
        return null;
    }
}
