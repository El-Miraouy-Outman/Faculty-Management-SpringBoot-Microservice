package com.miraouy.repository;

import com.miraouy.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FiliereRepository extends JpaRepository<Filiere,Long> {
}
