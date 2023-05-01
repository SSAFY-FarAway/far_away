package com.ssafy.faraway.domain.hotplace.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class HotPlaceLike {
    private long hotPlaceId;
    private long memberId;
    private LocalDateTime createdDate;

    @Builder
    public HotPlaceLike(long hotPlaceId, long memberId) {
        this.hotPlaceId = hotPlaceId;
        this.memberId = memberId;
    }
}
