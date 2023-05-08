package com.ssafy.faraway.domain.post.dto.req;

import com.ssafy.faraway.domain.member.entity.Member;
import com.ssafy.faraway.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@ToString
public class PostSaveRequestDto {
    @NotBlank(message = "카테고리를 입력해주세요.")
    @Size(max = 20, message = "카테고리는 20자 이하입니다.")
    private String category;
    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 30, message = "제목을 30자 이하입니다.")
    private String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    @NotNull(message = "사용자 정보가 없습니다.")
    private Member member;

    @Builder
    public PostSaveRequestDto(String category, String title, String content, Member member) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public Post toEntity() {
        return Post.builder()
                .member(member)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}
