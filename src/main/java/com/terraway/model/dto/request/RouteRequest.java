package com.terraway.model.dto.request;

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
public class RouteRequest {
    private String name;
    private List<Coordinate> coordinates;
    int parkId;
    private String difficulty;
}