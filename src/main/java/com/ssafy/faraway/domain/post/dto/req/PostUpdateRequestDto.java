package com.ssafy.faraway.domain.post.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private long id;
    private String category;
    private String title;
    private String content;

    @Builder
    public PostUpdateRequestDto(long id, String category, String title, String content) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
