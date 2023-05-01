package com.ssafy.faraway.domain.post.dto.res;

import com.ssafy.faraway.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private long id;
    private long memberId;
    private String loginId;
    private String category;
    private String title;
    private String content;
    private long hit;
    private LocalDateTime modifiedDate;

    @Builder
    public PostResponseDto(long id, long memberId, String loginId, String category, String title, String content, long hit, LocalDateTime modifiedDate) {
        this.id = id;
        this.memberId = memberId;
        this.loginId = loginId;
        this.category = category;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.modifiedDate = modifiedDate;
    }
}
