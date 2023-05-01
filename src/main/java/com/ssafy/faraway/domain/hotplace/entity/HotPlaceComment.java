package com.ssafy.faraway.domain.hotplace.entity;

import lombok.Builder;

import java.time.LocalDateTime;

public class HotPlaceComment {
    private long id;
    private long hotPlaceId;
    private long memberId;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public HotPlaceComment(long hotPlaceId, long memberId, String content) {
        this.hotPlaceId = hotPlaceId;
        this.memberId = memberId;
        this.content = content;
    }
}
