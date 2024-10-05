package com.terraway.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "places")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    double laitute;
    double longitute;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "place")
    List<PhotoEntity> photos;

}
