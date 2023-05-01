package com.ssafy.faraway.domain.post.dto.req;

import com.ssafy.faraway.domain.post.entity.PostComment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PostCommentSaveRequestDto {
    private long postId;
    private long memberId;
    private String content;

    @Builder
    public PostCommentSaveRequestDto(long postId, long memberId, String content) {
        this.postId = postId;
        this.memberId = memberId;
        this.content = content;
    }

    public PostComment toEntity() {
        return PostComment.builder()
                .postId(postId)
                .memberId(memberId)
                .content(content)
                .build();
    }
}
