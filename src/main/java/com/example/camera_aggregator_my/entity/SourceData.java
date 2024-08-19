package com.example.camera_aggregator_my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceData {
    private String urlType;
    private String videoUrl;
}
