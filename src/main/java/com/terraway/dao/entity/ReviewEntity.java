package com.terraway.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String comment;
    int rating;
    @CreationTimestamp
    LocalDateTime createdAt;
    @ManyToOne
    UserEntity user;
    @ManyToOne
    ParkEntity park;
    @UpdateTimestamp
    LocalDateTime updatedAt;
}
