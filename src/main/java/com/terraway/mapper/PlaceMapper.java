package com.terraway.mapper;


import com.terraway.dao.entity.*;
import com.terraway.model.dto.request.ParkRequest;
import com.terraway.model.dto.request.PlaceRequest;
import com.terraway.model.dto.response.ParkResponse;
import com.terraway.model.dto.response.PlaceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    PlaceEntity requestToEntity(PlaceRequest placeRequest);

    PlaceResponse entityToResponse(PlaceEntity place, List<PhotoEntity> photos);
}
