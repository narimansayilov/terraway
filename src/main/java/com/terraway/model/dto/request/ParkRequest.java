package com.terraway.model.dto.request;

import com.terraway.dao.entity.ReviewEntity;
import com.terraway.dao.entity.RouteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkRequest {
    String name;
    private String location;  // Parkın bulunduğu konum (şehir, bölge vb.)
    private String description;
}
