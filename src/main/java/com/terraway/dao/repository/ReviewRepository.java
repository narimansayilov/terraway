package com.terraway.dao.repository;

import com.terraway.dao.entity.ReviewEntity;
import com.terraway.dao.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, PagingAndSortingRepository<ReviewEntity, Long>, JpaSpecificationExecutor<ReviewEntity> {
List<ReviewEntity> findAllByParkId(long id);
}
