package com.ssafy.faraway.domain.post.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostCommentListResponseDto {
    private long id;
    private long postId;
    private long memberId;
    private String loginId;
    private String conent;
    private LocalDateTime createdDate;

    @Builder
    public PostCommentListResponseDto(long id, long postId, long memberId, String loginId, String conent, LocalDateTime createdDate) {
        this.id = id;
        this.postId = postId;
        this.memberId = memberId;
        this.loginId = loginId;
        this.conent = conent;
        this.createdDate = createdDate;
    }
}
