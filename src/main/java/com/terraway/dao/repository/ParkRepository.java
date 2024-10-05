package com.terraway.dao.repository;

import com.terraway.dao.entity.ParkEntity;
import com.terraway.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkRepository extends JpaRepository<ParkEntity, Long>, PagingAndSortingRepository<ParkEntity, Long>, JpaSpecificationExecutor<ParkEntity> {

}
