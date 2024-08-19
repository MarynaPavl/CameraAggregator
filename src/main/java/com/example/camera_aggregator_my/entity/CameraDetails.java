package com.example.camera_aggregator_my.entity;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CameraDetails {
    private int id;
    private String urlType;
    private String videoUrl;
    private String value;
    private int ttl;

    public CameraDetails(int id, String urlType, String videoUrl, String value, int ttl) {
        this.id = id;
        this.urlType = urlType;
        this.videoUrl = videoUrl;
        this.value = value;
        this.ttl = ttl;
    }


}
