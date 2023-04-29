package com.miraouy.Controller;

import com.miraouy.Exception.Filiere.FiliereNotFound;
import com.miraouy.Exception.ModuleF.ModuleNotFound;
import com.miraouy.Exception.Note.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.NoteResponseDto;
import com.miraouy.service.NoteService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController  {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public NoteResponseDto addNote(@RequestBody NoteRequestDto note) {
        System.out.println("bonsoir bonjor");
        return noteService.addNote(note);
    }
    //listes des notes d'un etudiant de toutes les modules
    @GetMapping("/ids{idStudent}")
    public List<NoteResponseDto> findNotesEtudiant(@PathVariable Long idStudent) {
       return noteService.findNotesEtudiant(idStudent);
    }

    //note d'un etudiant pour un modules specifique
    @GetMapping("/ids{idStudent}/idm{idModule}")
    public NoteResponseDto findNoteStudentModule(@PathVariable Long idStudent,@PathVariable Long idModule) throws NoteNotFound {
        return noteService.findNoteByStudentAndModule(idStudent,idModule);
    }

    //listes des notes d'une module pour une filiere
    @GetMapping("/idf{idFiliere}/idm{idModule}")
    public List<NoteResponseDto>  findNoteFiliereModule(@PathVariable Long idFiliere , @PathVariable Long idModule) throws ModuleNotFound, FiliereNotFound {
        return noteService.findNoteFiliereAndModule(idFiliere, idModule);
    }


    @DeleteMapping("/{idStudent}/{idModule}")
    public NoteResponseDto deleteNote(Long idStudent, Long idModule) throws NoteNotFound {
        return null;
    }

    @PutMapping("/{idStudent}/{idModule}")
    public NoteResponseDto updaeNote(Long idStudent, Long idModule) throws NoteNotFound {
        return null;
    }
}
