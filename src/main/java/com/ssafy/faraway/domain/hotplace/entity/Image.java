package com.ssafy.faraway.domain.hotplace.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Image {
    private long id;
    private String hotPlaceId;
    private String name;
    private String path;
}
