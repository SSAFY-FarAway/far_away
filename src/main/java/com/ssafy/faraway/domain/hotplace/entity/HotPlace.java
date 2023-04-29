package com.ssafy.faraway.domain.hotplace.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HotPlace {
    private long id;
    private long memberId;
    private String title;
    private String content;
    private String zipcode;
    private String mainAddress;
    private String subAddress;
    private int rating;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}