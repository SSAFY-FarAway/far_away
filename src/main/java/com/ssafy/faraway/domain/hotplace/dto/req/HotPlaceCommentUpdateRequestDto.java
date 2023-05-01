package com.ssafy.faraway.domain.hotplace.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class HotPlaceCommentUpdateRequestDto {
    @NotNull(message = "댓글 정보가 없습니다.")
    private long id;
    @NotNull(message = "게시글 정보가 없습니다.")
    private long hotPlaceId;
    @NotNull(message = "사용자 정보가 없습니다.")
    private long memberId;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @Builder
    public HotPlaceCommentUpdateRequestDto(long id, long hotPlaceId, long memberId, String content) {
        this.id = id;
        this.hotPlaceId = hotPlaceId;
        this.memberId = memberId;
        this.content = content;
    }
}
