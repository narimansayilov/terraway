package com.terraway.controller;

import com.terraway.dao.entity.PlaceEntity;
import com.terraway.model.dto.request.PlaceRequest;
import com.terraway.model.dto.response.PlaceResponse;
import com.terraway.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terraway/place")
public class PlaceController {
    private final PlaceService placeService
            ;

    @PostMapping
    public void createPlace(@RequestPart(name = "request") PlaceRequest request,
                           @RequestPart(name = "photo") MultipartFile[] files) {
        placeService.createPlace(request, files);
    }

    @GetMapping
    public List<PlaceResponse> getAllPlaces() {
        return placeService.getPlaces();
    }
}