package com.miraouy.repository;

import com.miraouy.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByIdStudent(Long isStudent);
}
