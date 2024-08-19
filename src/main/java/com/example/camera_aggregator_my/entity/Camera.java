package com.example.camera_aggregator_my.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Camera {
    private int id;
    private String sourceDataUrl;
    private String tokenDataUrl;

}
