package com.terraway.controller;

import com.terraway.model.dto.request.PopulationRequest;
import com.terraway.model.dto.request.RouteRequest;
import com.terraway.model.dto.response.PopulationResponse;
import com.terraway.model.dto.response.RouteResponse;
import com.terraway.service.PopulationService;
import com.terraway.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terraway/route")
public class RouteController {
    private final RouteService routeService;

    @PostMapping
    public void createPopulation(@RequestPart(name = "request") RouteRequest request,
                            @RequestPart(name = "photo") MultipartFile[] files) {
        routeService.createRoute(request, files);
    }

    @GetMapping
    public List<RouteResponse> getAllPopulations() {
        return routeService.getRoutes();
    }
}