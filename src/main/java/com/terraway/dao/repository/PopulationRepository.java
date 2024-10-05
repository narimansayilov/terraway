package com.terraway.dao.repository;

import com.terraway.dao.entity.PopulationEntity;
import com.terraway.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PopulationRepository extends JpaRepository<PopulationEntity, Long> {
}
