package com.miraouy.service;

import com.miraouy.ClientFeign.Student;
import com.miraouy.Exception.Filiere.FiliereNotFound;
import com.miraouy.Exception.ModuleF.ModuleNotFound;
import com.miraouy.Exception.Note.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.NoteResponseDto;
import com.miraouy.model.Filiere;
import com.miraouy.model.ModuleF;
import com.miraouy.model.Note;
import com.miraouy.repository.FiliereRepository;
import com.miraouy.repository.ModuleRepository;
import com.miraouy.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService{
    private final ModuleRepository moduleRepository;
    private final NoteRepository noteRepository;
    private final FiliereRepository filiereRepository;
    private final StudentService studentService;

    public NoteServiceImpl(ModuleRepository moduleRepository, NoteRepository noteRepository, FiliereRepository filiereRepository, StudentService studentService) {
        this.moduleRepository = moduleRepository;
        this.noteRepository = noteRepository;
        this.filiereRepository = filiereRepository;
        this.studentService = studentService;
    }

    @Override
    public NoteResponseDto addNote(NoteRequestDto noteRequestDto) {
        ModuleF module=moduleRepository.findById(noteRequestDto.getIdModule()).get();
        System.out.println(module);
        System.out.println("helloooo****");
        Note note=Note.builder()
                .note(noteRequestDto.getNote())
                .module(module)
                .idStudent(noteRequestDto.getIdStudent())
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
        List<Note> listNotes = noteRepository.findByIdStudent(idStudent);
        Student student=studentService.getStudent(idStudent);
       Note note= listNotes.stream()
                .filter(noteitem -> noteitem.getModule().getIdModule()==idModule)
                .findFirst()
               .orElse(null);
       if(note==null)
           throw new NoteNotFound("note not exist");
        NoteResponseDto noteResponseDto = NoteResponseDto
                .builder()
                .note(note.getNote())
                .idStudent(idStudent)
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
        Filiere filiere = filiereRepository.findById(idFiliere).orElseThrow(() -> new FiliereNotFound("Filiere not found"));
        ModuleF module = moduleRepository.findById(idModule).orElseThrow(() -> new ModuleNotFound("Module not found"));
        List<Note> notes = noteRepository.findByModuleAndFiliere(module, filiere);
        return notes.stream().map(note -> new NoteResponseDto(note.getNote(), note.getIdStudent())).collect(Collectors.toList());
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
