package com.example.camera_aggregator_my.controller;


import com.example.camera_aggregator_my.entity.CameraDetails;
import com.example.camera_aggregator_my.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/cameras")
public class CameraController {
    private final CameraService cameraService;

    @Autowired
    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }
    @GetMapping
    public Flux<CameraDetails> getAggregatedCameraData() {
        return cameraService.getAggregatedCameraData();
    }
}
