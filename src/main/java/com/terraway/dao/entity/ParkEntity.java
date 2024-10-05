package com.terraway.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parks")
public class ParkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    private String location;  // Parkın bulunduğu konum (şehir, bölge vb.)

    private String description;

//    @OneToMany(mappedBy = "park")
//    private List<RouteEntity> routes;
//
//    @OneToMany(mappedBy = "park")
//    List<ReviewEntity> reviews;
//    @OneToMany(mappedBy = "park",cascade = CascadeType.MERGE)
//    List<PhotoEntity> photos;
    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}
