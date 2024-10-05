package com.terraway.mapper;


import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PlaceEntity;
import com.terraway.dao.entity.ReviewEntity;
import com.terraway.model.dto.request.PlaceRequest;
import com.terraway.model.dto.request.ReviewRequest;
import com.terraway.model.dto.response.PlaceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target ="user.id",source = "request.userId")
    @Mapping(target ="park.id",source = "request.parkId")
    ReviewEntity requestToEntity(ReviewRequest request);

}
