package com.ssafy.faraway.domain.post.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class PostLike {
    private long postId;
    private long memberId;
    private LocalDateTime createdDate;

    @Builder
    public PostLike(long postId, long memberId) {
        this.postId = postId;
        this.memberId = memberId;
    }
}
