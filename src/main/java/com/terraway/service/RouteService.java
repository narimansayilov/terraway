package com.terraway.service;

import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PopulationEntity;
import com.terraway.dao.entity.RouteEntity;
import com.terraway.dao.repository.PhotoRepository;
import com.terraway.dao.repository.RouteRepository;
import com.terraway.mapper.PopulationMapper;
import com.terraway.mapper.RouteMapper;
import com.terraway.model.dto.request.PopulationRequest;
import com.terraway.model.dto.request.RouteRequest;
import com.terraway.model.dto.response.PopulationResponse;
import com.terraway.model.dto.response.RouteResponse;
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
public class RouteService {
    private final RouteRepository routeRepository;
    private final AmazonS3Service s3Service;
    private final PhotoRepository photoRepository;


    @Transactional
    public void createRoute(RouteRequest request, MultipartFile[] files) {
        RouteEntity route = RouteMapper.INSTANCE.requestToEntity(request);
        RouteEntity save1 = routeRepository.save(route);

        List<PhotoEntity> photos = new ArrayList<>();
        for (MultipartFile f : files) {
            PhotoEntity photoEntity = new PhotoEntity();
            photoEntity.setPhotoUrl(s3Service.uploadFile(f));
            photoEntity.setRoute(save1);
            PhotoEntity save = photoRepository.save(photoEntity);
            photos.add(save);
        }
    }

    public List<RouteResponse> getRoutes() {
        List<RouteEntity> all = routeRepository.findAll();
        return all.stream().map(i -> RouteMapper.INSTANCE.entityToResponse(
                i,
                photoRepository.findAllByRouteId(i.getId()))).toList();

    }
}