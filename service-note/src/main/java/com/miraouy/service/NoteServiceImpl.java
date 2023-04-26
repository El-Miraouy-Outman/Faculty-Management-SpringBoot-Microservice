package com.miraouy.service;

import com.miraouy.Exception.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.NoteResponseDto;
import com.miraouy.model.ModuleF;
import com.miraouy.model.Note;
import com.miraouy.repository.ModuleRepository;
import com.miraouy.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService{
    private final ModuleRepository moduleRepository;
    private final NoteRepository noteRepository;

    public NoteServiceImpl(ModuleRepository moduleRepository, NoteRepository noteRepository) {
        this.moduleRepository = moduleRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteResponseDto addNote(NoteRequestDto noteRequestDto) {
        log.warn("{}",noteRequestDto.getIdModule());

        ModuleF module=moduleRepository.findById(noteRequestDto.getIdModule()).get();
        Note note=Note.builder()
                .note(noteRequestDto.getNote())
                .module(module)
                .idStudent(noteRequestDto.getIdStudent())
                .build();
        Note noteSave=noteRepository.save(note);
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
       if(note==null)
           throw new NoteNotFound("note not found");
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
