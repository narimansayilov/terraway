package com.terraway.mapper;


import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PlaceEntity;
import com.terraway.dao.entity.PopulationEntity;
import com.terraway.model.dto.request.PlaceRequest;
import com.terraway.model.dto.request.PopulationRequest;
import com.terraway.model.dto.response.PlaceResponse;
import com.terraway.model.dto.response.PopulationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PopulationMapper {
    PopulationMapper INSTANCE = Mappers.getMapper(PopulationMapper.class);

    PopulationEntity requestToEntity(PopulationRequest populationRequest);

    PopulationResponse entityToResponse(PopulationEntity place, List<PhotoEntity> photos);
}
