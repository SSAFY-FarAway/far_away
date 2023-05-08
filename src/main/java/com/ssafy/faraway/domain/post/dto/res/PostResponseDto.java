package com.ssafy.faraway.domain.post.dto.res;

import com.ssafy.faraway.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id;
    private Long memberId;
    private String loginId;
    private String category;
    private String title;
    private String content;
    private Long hit;
    private LocalDateTime createdDate;

    @Builder
    public PostResponseDto(Long id, Long memberId, String loginId, String category, String title, String content, Long hit, LocalDateTime createdDate) {
        this.id = id;
        this.memberId = memberId;
        this.loginId = loginId;
        this.category = category;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.createdDate = createdDate;
    }
}
