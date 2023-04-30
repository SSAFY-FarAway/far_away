package com.ssafy.faraway.domain.post.dto.req;

import com.ssafy.faraway.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private long memberId;
    private String category;
    private String title;
    private String content;

    @Builder
    public PostSaveRequestDto(long memberId, String category, String title, String content) {
        this.memberId = memberId;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .memberId(memberId)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}
