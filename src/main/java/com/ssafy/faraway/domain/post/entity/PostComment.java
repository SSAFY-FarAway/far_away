package com.ssafy.faraway.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class PostComment {
    private long id;
    private long postId;
    private long memberId;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public PostComment(long postId, long memberId, String content) {
        this.postId = postId;
        this.memberId = memberId;
        this.content = content;
    }
}
