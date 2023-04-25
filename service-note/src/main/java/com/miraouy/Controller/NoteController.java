package com.miraouy.Controller;

import com.miraouy.Exception.NoteNotFound;
import com.miraouy.dto.Request.NoteRequestDto;
import com.miraouy.dto.Response.NoteResponseDto;
import com.miraouy.service.NoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin("*")
public class NoteController  {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public NoteResponseDto addNote(@RequestBody NoteRequestDto note) {
        return noteService.addNote(note);
    }

    @GetMapping("/{idStudent}/{idModule}")
    public NoteResponseDto findNote(@PathVariable Long idStudent,@PathVariable Long idModule) throws NoteNotFound {
        return noteService.findNote(idStudent,idModule);
    }

    @GetMapping
    public NoteResponseDto findAllNotes() {
        return null;
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
