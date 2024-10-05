package com.terraway.mapper;


import com.terraway.dao.entity.*;
import com.terraway.model.dto.request.ParkRequest;
import com.terraway.model.dto.request.RoleRequest;
import com.terraway.model.dto.response.ParkResponse;
import com.terraway.model.dto.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ParkMapper {
    ParkMapper INSTANCE = Mappers.getMapper(ParkMapper.class);

    ParkEntity requestToEntity(ParkRequest roleRequest);

    ParkResponse entityToResponse(ParkEntity roleRequest, List<PhotoEntity> photos,
                                  List<ReviewEntity> reviews, List<RouteEntity> routes);
}
