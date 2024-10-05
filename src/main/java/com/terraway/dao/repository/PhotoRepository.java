package com.terraway.dao.repository;

import com.terraway.dao.entity.ParkEntity;
import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends
        JpaRepository<PhotoEntity, Long>, PagingAndSortingRepository<PhotoEntity, Long>, JpaSpecificationExecutor<PhotoEntity> {
    List<PhotoEntity> findAllByParkId(long id);
    List<PhotoEntity> findAllByPlaceId(long id);
    List<PhotoEntity> findAllByPopulationId(long id);
    List<PhotoEntity> findAllByRouteId(long id);

}
