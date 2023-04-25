package com.miraouy.repository;

import com.miraouy.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note,Long> {
}
