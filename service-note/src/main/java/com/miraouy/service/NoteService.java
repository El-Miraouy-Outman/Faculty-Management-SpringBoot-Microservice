package com.miraouy.service;

import com.miraouy.Exception.Filiere.FiliereNotFound;
import com.miraouy.Exception.ModuleF.ModuleNotFound;
import com.miraouy.Exception.Note.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.NoteResponseDto;

import java.util.List;

public interface NoteService {
     NoteResponseDto addNote(NoteRequestDto note) ;

    NoteResponseDto findNoteByStudentAndModule(Long idStudent, Long idModule) throws NoteNotFound;

     List<NoteResponseDto> findNotesEtudiant(Long idStudent);
     List<NoteResponseDto> findNoteFiliereAndModule(Long idFiliere,Long idModule) throws FiliereNotFound, ModuleNotFound;
     NoteResponseDto deleteNote(Long idStudent,Long idModule) throws NoteNotFound;
     NoteResponseDto updaeNote(Long idStudent,Long idModule) throws NoteNotFound;
}
