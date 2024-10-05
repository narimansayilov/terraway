package com.terraway.model.dto.response;

import com.terraway.dao.entity.PhotoEntity;
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
public class PopulationResponse {

    private String name;
    private String description;
    private String habitat;
    private String conservationStatus;
    private int populationEstimate;
    private String weightRangeKg;
    private String heightRangeCm;
    private String diet;
    private String type;

    List<PhotoEntity> photos;

}
