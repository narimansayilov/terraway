package com.terraway.service;

import com.terraway.dao.entity.ParkEntity;
import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.RoleEntity;
import com.terraway.dao.entity.UserEntity;
import com.terraway.dao.repository.*;
import com.terraway.mapper.ParkMapper;
import com.terraway.mapper.UserMapper;
import com.terraway.model.dto.criteria.UserCriteriaRequest;
import com.terraway.model.dto.request.ParkRequest;
import com.terraway.model.dto.request.UserUpdateRequest;
import com.terraway.model.dto.response.ParkResponse;
import com.terraway.model.dto.response.UserResponse;
import com.terraway.model.exception.ActiveException;
import com.terraway.model.exception.AlreadyExistsException;
import com.terraway.model.exception.NotActiveException;
import com.terraway.model.exception.NotFoundException;
import com.terraway.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkService {
    private final ParkRepository parkRepository;
    private final AmazonS3Service s3Service;
    private final PhotoRepository photoRepository;
    private final RouteRepository routeRepository;
    private final ReviewRepository reviewRepository;

@Transactional
    public void createPark(ParkRequest request, MultipartFile[] files) {
        ParkEntity parkEntity = ParkMapper.INSTANCE.requestToEntity(request);
        ParkEntity save1 = parkRepository.save(parkEntity);

        List<PhotoEntity> photos = new ArrayList<>();
        for (MultipartFile f : files) {
            PhotoEntity photoEntity = new PhotoEntity();
            photoEntity.setPhotoUrl(s3Service.uploadFile(f));
            photoEntity.setPark(save1);
            PhotoEntity save = photoRepository.save(photoEntity);
            photos.add(save);
        }
    }

    public List<ParkResponse> getParks() {
        List<ParkEntity> all = parkRepository.findAll();
        return all.stream().map(i -> ParkMapper.INSTANCE.entityToResponse(
                i,
                photoRepository.findAllByParkId(i.getId()),
                reviewRepository.findAllByParkId(i.getId()),
                routeRepository.findAllByParkId(i.getId()))).toList();

    }
}