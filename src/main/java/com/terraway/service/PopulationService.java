package com.terraway.service;

import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PlaceEntity;
import com.terraway.dao.entity.PopulationEntity;
import com.terraway.dao.repository.*;
import com.terraway.mapper.PlaceMapper;
import com.terraway.mapper.PopulationMapper;
import com.terraway.model.dto.request.PopulationRequest;
import com.terraway.model.dto.response.PlaceResponse;
import com.terraway.model.dto.response.PopulationResponse;
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
public class PopulationService {
    private final PopulationRepository populationRepository;
    private final AmazonS3Service s3Service;
    private final PhotoRepository photoRepository;


    @Transactional
    public void createPopulation(PopulationRequest request, MultipartFile[] files) {
        PopulationEntity population = PopulationMapper.INSTANCE.requestToEntity(request);
        PopulationEntity save1 = populationRepository.save(population);

        List<PhotoEntity> photos = new ArrayList<>();
        for (MultipartFile f : files) {
            PhotoEntity photoEntity = new PhotoEntity();
            photoEntity.setPhotoUrl(s3Service.uploadFile(f));
            photoEntity.setPopulation(save1);
            PhotoEntity save = photoRepository.save(photoEntity);
            photos.add(save);
        }
    }

    public List<PopulationResponse> getPopulations() {
        List<PopulationEntity> all = populationRepository.findAll();
        return all.stream().map(i -> PopulationMapper.INSTANCE.entityToResponse(
                i,
                photoRepository.findAllByPopulationId(i.getId()))).toList();

    }
}