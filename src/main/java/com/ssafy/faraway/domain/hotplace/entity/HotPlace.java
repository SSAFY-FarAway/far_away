package com.ssafy.faraway.domain.hotplace.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class HotPlace {
    private long id;
    private long memberId;
    private String title;
    private String content;
    private int hit;
    private String zipcode;
    private String mainAddress;
    private String subAddress;
    private int rating;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public HotPlace(long memberId, String title, String content, String zipcode, String mainAddress, String subAddress, int rating) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
        this.rating = rating;
    }
}
