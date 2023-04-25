package com.miraouy.service;

import com.miraouy.Exception.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.NoteResponseDto;

public interface NoteService {
    public NoteResponseDto addNote(NoteRequestDto note) ;

    NoteResponseDto findNote(Long idStudent, Long idModule) throws NoteNotFound;

    public NoteResponseDto findAllNotes();
    public NoteResponseDto deleteNote(Long idStudent,Long idModule) throws NoteNotFound;
    public NoteResponseDto updaeNote(Long idStudent,Long idModule) throws NoteNotFound;
}
