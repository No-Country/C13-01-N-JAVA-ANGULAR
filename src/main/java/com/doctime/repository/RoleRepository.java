package com.doctime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doctime.model.role.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
