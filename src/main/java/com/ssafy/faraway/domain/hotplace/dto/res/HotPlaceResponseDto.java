package com.ssafy.faraway.domain.hotplace.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HotPlaceResponseDto {
    private long id;
    private long memberId;
    private String loginId;
    private String title;
    private String content;
    private int hit;
    private String zipcode;
    private String mainAddress;
    private String subAddress;
    private int rating;
    private LocalDateTime createdDate;

    @Builder
    public HotPlaceResponseDto(long id, long memberId, String loginId, String title, String content, int hit, String zipcode, String mainAddress, String subAddress, int rating, LocalDateTime createdDate) {
        this.id = id;
        this.memberId = memberId;
        this.loginId = loginId;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
        this.rating = rating;
        this.createdDate = createdDate;
    }
}
