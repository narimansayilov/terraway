package com.terraway.dao.repository;

import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long>, PagingAndSortingRepository<RouteEntity, Long>, JpaSpecificationExecutor<RouteEntity> {

    List<RouteEntity> findAllByParkId(long id);
}
