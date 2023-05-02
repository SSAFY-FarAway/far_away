package com.ssafy.faraway.domain.post.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private long id;
    private long memberId;
    private String loginId;
    private String category;
    private String title;
    private long hit;
    private LocalDateTime createdDate;

    @Builder
    public PostListResponseDto(long id, long memberId, String loginId, String category, String title, long hit, LocalDateTime createdDate) {
        this.id = id;
        this.memberId = memberId;
        this.loginId = loginId;
        this.category = category;
        this.title = title;
        this.hit = hit;
        this.createdDate = createdDate;
    }
}
