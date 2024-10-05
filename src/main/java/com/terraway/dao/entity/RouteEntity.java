package com.terraway.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "routes")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "route_coordinates", joinColumns = @JoinColumn(name = "route_id"))
    @Column(name = "coordinate")
    private List<Coordinate> coordinates;

    @ManyToOne
    ParkEntity park;

    @Column(nullable = false)
    private String difficulty;
}