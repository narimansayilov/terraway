package com.terraway.dao.repository;

import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends
        JpaRepository<PlaceEntity, Long>, PagingAndSortingRepository<PlaceEntity, Long>, JpaSpecificationExecutor<PlaceEntity> {
//    List<PhotoEntity> findAllByParkId(long id);

}
