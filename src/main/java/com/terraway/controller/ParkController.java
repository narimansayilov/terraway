package com.terraway.controller;

import com.terraway.model.dto.criteria.UserCriteriaRequest;
import com.terraway.model.dto.request.ParkRequest;
import com.terraway.model.dto.request.UserUpdateRequest;
import com.terraway.model.dto.response.ParkResponse;
import com.terraway.model.dto.response.UserResponse;
import com.terraway.service.ParkService;
import com.terraway.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terraway/park")
public class ParkController {
    private final ParkService parkService;

    @PostMapping
    public void createPark(@RequestPart(name = "request") ParkRequest request,
                           @RequestPart(name = "photo") MultipartFile[] files) {
        parkService.createPark(request, files);
    }

    @GetMapping
    public List<ParkResponse> getAllParks() {
        return parkService.getParks();
    }
}