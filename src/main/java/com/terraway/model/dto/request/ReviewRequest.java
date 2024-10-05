package com.terraway.model.dto.request;

import com.terraway.dao.entity.ParkEntity;
import com.terraway.dao.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    String comment;
    int rating;
    long userId;
    long parkId;

}
