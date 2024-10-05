package com.terraway.mapper;


import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PopulationEntity;
import com.terraway.dao.entity.RouteEntity;
import com.terraway.model.dto.request.PopulationRequest;
import com.terraway.model.dto.request.RouteRequest;
import com.terraway.model.dto.response.PopulationResponse;
import com.terraway.model.dto.response.RouteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    @Mapping(target = "park.id", source = "request.parkId")
    RouteEntity requestToEntity(RouteRequest request);

    RouteResponse entityToResponse(RouteEntity entity, List<PhotoEntity> photos);
}
