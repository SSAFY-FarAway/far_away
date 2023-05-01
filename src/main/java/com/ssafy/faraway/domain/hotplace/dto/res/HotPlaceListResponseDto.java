package com.ssafy.faraway.domain.hotplace.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HotPlaceListResponseDto {
    private long id;
    private long memberId;
    private String loginId;
    private String title;
    private int hit;
    private String mainAddress;
    private int rating;
    private LocalDateTime modifiedDate;

    @Builder
    public HotPlaceListResponseDto(long id, long memberId, String loginId, String title, int hit, String mainAddress, int rating, LocalDateTime modifiedDate) {
        this.id = id;
        this.memberId = memberId;
        this.loginId = loginId;
        this.title = title;
        this.hit = hit;
        this.mainAddress = mainAddress;
        this.rating = rating;
        this.modifiedDate = modifiedDate;
    }
}
