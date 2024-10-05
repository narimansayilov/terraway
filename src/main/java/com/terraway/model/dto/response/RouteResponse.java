package com.terraway.model.dto.response;

import com.terraway.dao.entity.Coordinate;
import com.terraway.dao.entity.ParkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponse {

    private String name;

    private List<Coordinate> coordinates;

    private String difficulty;
}