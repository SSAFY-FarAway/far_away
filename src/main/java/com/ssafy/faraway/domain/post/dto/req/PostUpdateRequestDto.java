package com.ssafy.faraway.domain.post.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    @NotBlank(message = "카테고리를 입력해주세요.")
    @Size(max = 20, message = "카테고리는 20자 이하입니다.")
    private String category;
    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 30, message = "제목은 30자 이하입니다.")
    private String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @Builder
    public PostUpdateRequestDto(String category, String title, String content) {
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
