package com.ssafy.faraway.domain.hotplace.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HotPlaceCommentListResponseDto {
    private long id;
    private long memberId;
    private String loginId;
    private String content;
    private LocalDateTime createdDate;

    @Builder
    public HotPlaceCommentListResponseDto(long id, long memberId, String loginId, String content, LocalDateTime createdDate) {
        this.id = id;
        this.memberId = memberId;
        this.loginId = loginId;
        this.content = content;
        this.createdDate = createdDate;
    }
}
