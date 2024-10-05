package com.terraway.controller;

import com.terraway.model.dto.request.PlaceRequest;
import com.terraway.model.dto.request.PopulationRequest;
import com.terraway.model.dto.response.PlaceResponse;
import com.terraway.model.dto.response.PopulationResponse;
import com.terraway.service.PlaceService;
import com.terraway.service.PopulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terraway/population")
public class PopulationController {
    private final PopulationService populationService;

    @PostMapping
    public void createPopulation(@RequestPart(name = "request") PopulationRequest request,
                            @RequestPart(name = "photo") MultipartFile[] files) {
        populationService.createPopulation(request, files);
    }

    @GetMapping
    public List<PopulationResponse> getAllPopulations() {
        return populationService.getPopulations();
    }
}