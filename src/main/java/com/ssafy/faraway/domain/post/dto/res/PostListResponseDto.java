package com.ssafy.faraway.domain.post.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private Long id;
    private Long memberId;
    private String loginId;
    private String category;
    private String title;
    private Long hit;
    private LocalDateTime createdDate;

    @Builder
    public PostListResponseDto(Long id, Long memberId, String loginId, String category, String title, Long hit, LocalDateTime createdDate) {
        this.id = id;
        this.memberId = memberId;
        this.loginId = loginId;
        this.category = category;
        this.title = title;
        this.hit = hit;
        this.createdDate = createdDate;
    }
}
