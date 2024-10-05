package com.terraway.service;

import com.terraway.dao.entity.PhotoEntity;
import com.terraway.dao.entity.PlaceEntity;
import com.terraway.dao.entity.ReviewEntity;
import com.terraway.dao.repository.PhotoRepository;
import com.terraway.dao.repository.PlaceRepository;
import com.terraway.dao.repository.ReviewRepository;
import com.terraway.mapper.PlaceMapper;
import com.terraway.mapper.ReviewMapper;
import com.terraway.model.dto.request.PlaceRequest;
import com.terraway.model.dto.request.ReviewRequest;
import com.terraway.model.dto.response.PlaceResponse;
import com.terraway.model.dto.response.ReviewResponse;
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
public class ReviewService {
    private final ReviewRepository reviewRepository;


    public void createReview(ReviewRequest request) {
        ReviewEntity review = ReviewMapper.INSTANCE.requestToEntity(request);
        reviewRepository.save(review);
    }
}