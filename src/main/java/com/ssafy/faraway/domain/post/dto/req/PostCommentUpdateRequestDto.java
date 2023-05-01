package com.ssafy.faraway.domain.post.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
public class PostCommentUpdateRequestDto {
    @NotNull(message = "댓글 정보가 없습니다.")
    private long id;
    @NotNull(message = "게시글 정보가 없습니다.")
    private long postId;
    @NotNull(message = "사용자 정보가 없습니다.")
    private long memberId;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @Builder
    public PostCommentUpdateRequestDto(long id, long postId, long memberId, String content) {
        this.id = id;
        this.postId = postId;
        this.memberId = memberId;
        this.content = content;
    }
}
