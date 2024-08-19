package com.example.camera_aggregator_my.service;

import com.example.camera_aggregator_my.entity.Camera;
import com.example.camera_aggregator_my.entity.CameraDetails;
import com.example.camera_aggregator_my.entity.SourceData;
import com.example.camera_aggregator_my.entity.TokenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CameraService {
    private final WebClient webClient;

    @Autowired
    public CameraService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Flux<CameraDetails> getAggregatedCameraData() {
        String cameraListUrl = "https://run.mocky.io/v3/acc75ac0-84fd-4d6c-9443-4155e5604d4d";
        return webClient.get()
                .uri(cameraListUrl)
                .retrieve()
                .bodyToFlux(Camera.class)
                .flatMap(camera -> getCameraDetails(camera))
                .onErrorResume(e -> Flux.empty());
    }

    private Mono<CameraDetails> getCameraDetails(Camera camera) {
        return Mono.zip(
                webClient.get().uri(camera.getSourceDataUrl()).retrieve().bodyToMono(SourceData.class),
                webClient.get().uri(camera.getTokenDataUrl()).retrieve().bodyToMono(TokenData.class),
                (sourceData, tokenData) -> new CameraDetails(
                        camera.getId(),
                        sourceData.getUrlType(),
                        sourceData.getVideoUrl(),
                        tokenData.getValue(),
                        tokenData.getTtl()
                )
        );
    }
}
