package com.terraway.service;

import com.terraway.dao.entity.ParkEntity;
import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PlaceEntity;
import com.terraway.dao.repository.*;
import com.terraway.mapper.ParkMapper;
import com.terraway.mapper.PlaceMapper;
import com.terraway.model.dto.request.ParkRequest;
import com.terraway.model.dto.request.PlaceRequest;
import com.terraway.model.dto.response.ParkResponse;
import com.terraway.model.dto.response.PlaceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final AmazonS3Service s3Service;
    private final PhotoRepository photoRepository;


@Transactional
    public void createPlace(PlaceRequest request, MultipartFile[] files) {
        PlaceEntity place = PlaceMapper.INSTANCE.requestToEntity(request);
        PlaceEntity save1 = placeRepository.save(place);

        List<PhotoEntity> photos = new ArrayList<>();
        for (MultipartFile f : files) {
            PhotoEntity photoEntity = new PhotoEntity();
            photoEntity.setPhotoUrl(s3Service.uploadFile(f));
            photoEntity.setPlace(save1);
            PhotoEntity save = photoRepository.save(photoEntity);
            photos.add(save);
        }
    }

    public List<PlaceResponse> getPlaces() {
        List<PlaceEntity> all = placeRepository.findAll();
        return all.stream().map(i -> PlaceMapper.INSTANCE.entityToResponse(
                i,
                photoRepository.findAllByPlaceId(i.getId()))).toList();

    }
}