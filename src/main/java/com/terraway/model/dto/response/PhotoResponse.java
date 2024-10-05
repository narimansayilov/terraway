package com.terraway.model.dto.response;

import com.terraway.dao.entity.ParkEntity;
import com.terraway.dao.entity.PlaceEntity;
import com.terraway.dao.entity.PopulationEntity;
import com.terraway.dao.entity.RouteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoResponse {
     String photoUrl;

}