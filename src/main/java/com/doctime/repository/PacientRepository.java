package com.doctime.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doctime.models.pacient.PacientEntity;

import java.util.Optional;

@Repository
public interface PacientRepository extends CrudRepository<PacientEntity, Long> {

    Optional<PacientEntity> findByUsername(String username);

    @Query("select u from PacientEntity u where u.username = ?1")
    Optional<PacientEntity> getName(String username);
}
