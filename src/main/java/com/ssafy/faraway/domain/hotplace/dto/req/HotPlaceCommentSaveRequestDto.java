package com.ssafy.faraway.domain.hotplace.dto.req;


import com.ssafy.faraway.domain.hotplace.entity.HotPlaceComment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
public class HotPlaceCommentSaveRequestDto {
    @NotNull(message = "게시글 정보가 없습니다.")
    private long hotPlaceId;
    @NotNull(message = "사용자 정보가 없습니다.")
    private long memberId;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @Builder
    public HotPlaceCommentSaveRequestDto(long hotPlaceId, long memberId, String content) {
        this.hotPlaceId = hotPlaceId;
        this.memberId = memberId;
        this.content = content;
    }

    public HotPlaceComment toEntity() {
        return HotPlaceComment.builder()
                .hotPlaceId(hotPlaceId)
                .memberId(memberId)
                .content(content)
                .build();
    }
}
