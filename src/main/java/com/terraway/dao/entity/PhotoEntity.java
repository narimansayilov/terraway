package com.terraway.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoUrl;
    @ManyToOne
    PopulationEntity population;
    @ManyToOne
    ParkEntity park;
    @ManyToOne
    PlaceEntity place;
    @ManyToOne
    RouteEntity route;
}