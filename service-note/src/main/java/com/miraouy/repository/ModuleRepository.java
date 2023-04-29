package com.miraouy.repository;

import com.miraouy.ClientFeign.ModuleF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<ModuleF,Long> {
}
