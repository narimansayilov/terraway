package com.terraway.model.dto.response;

import com.terraway.dao.entity.Coordinate;
import com.terraway.dao.entity.PhotoEntity;
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
public class PlaceResponse {
    private String name;

    double laitute;
    double longitute;
    private String description;

    List<PhotoResponse> photos;

}
