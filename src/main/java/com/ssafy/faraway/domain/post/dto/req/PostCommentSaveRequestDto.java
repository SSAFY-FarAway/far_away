package com.ssafy.faraway.domain.post.dto.req;

import com.ssafy.faraway.domain.post.entity.PostComment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
public class PostCommentSaveRequestDto {
    @NotNull(message = "게시글 정보가 없습니다.")
    private long postId;
    @NotNull(message = "사용자 정보가 없습니다.")
    private long memberId;
    @NotBlank(message = "내용을 입력해주세요.")
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
