package com.ssafy.faraway.domain.hotplace.entity;

import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class Image {
    private long id;
    private String hotPlaceId;
    private String name;
    private String path;

    @Builder
    public Image(String hotPlaceId, String name, String path) {
        this.hotPlaceId = hotPlaceId;
        this.name = name;
        this.path = path;
    }
}
