package com.ssafy.faraway.domain.post.dto.res;

import com.ssafy.faraway.domain.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private long id;
    private long memberId;
    private String category;
    private String title;
    private long hit;
    private LocalDateTime modifiedDate;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.memberId = entity.getMemberId();
        this.category = entity.getCategory();
        this.title = entity.getTitle();
        this.hit = entity.getHit();
        this.modifiedDate = entity.getModifiedDate();
    }
}
