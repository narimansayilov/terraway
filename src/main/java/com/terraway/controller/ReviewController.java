package com.terraway.controller;

import com.terraway.model.dto.request.PopulationRequest;
import com.terraway.model.dto.request.ReviewRequest;
import com.terraway.model.dto.response.PopulationResponse;
import com.terraway.service.PopulationService;
import com.terraway.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terraway/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public void createReview(@RequestBody ReviewRequest request) {
        reviewService.createReview(request);
    }

}