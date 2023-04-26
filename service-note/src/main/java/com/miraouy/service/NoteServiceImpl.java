package com.miraouy.service;

import com.miraouy.Exception.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.NoteResponseDto;
import com.miraouy.model.ModuleF;
import com.miraouy.model.Note;
import com.miraouy.repository.ModuleRepository;
import com.miraouy.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    private final ModuleRepository moduleRepository;
    private final NoteRepository noteRepository;

    public NoteServiceImpl(ModuleRepository moduleRepository, NoteRepository noteRepository) {
        this.moduleRepository = moduleRepository;
        this.noteRepository = noteRepository;
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
    public NoteResponseDto findNote(Long idStudent, Long idModule) throws NoteNotFound {
        List<Note> listNotes = noteRepository.findByIdStudent(idStudent);
       Note note= listNotes.stream()
                .filter(noteitem -> noteitem.getModule().getIdModule()==idModule)
                .findFirst()
               .orElse(null);
       //get student by Id
        NoteResponseDto noteResponseDto = NoteResponseDto
                .builder()
                .note(note.getNote())
                //.student(student)
                    .build();
        return noteResponseDto;
    }

    @Override
    public NoteResponseDto findAllNotes() {
        return null;
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
