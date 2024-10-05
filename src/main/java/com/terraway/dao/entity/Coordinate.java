package com.terraway.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Coordinate {

    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;

}