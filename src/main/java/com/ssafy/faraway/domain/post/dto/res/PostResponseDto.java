package com.ssafy.faraway.domain.post.dto.res;

import com.ssafy.faraway.domain.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private long id;
    private long memberId;
    private String category;
    private String title;
    private String content;
    private long hit;
    private LocalDateTime modifiedDate;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.memberId = entity.getMemberId();
        this.category = entity.getCategory();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.hit = entity.getHit();
        this.modifiedDate = entity.getModifiedDate();
    }
}
