package com.ssafy.faraway.domain.hotplace.dto.req;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class HotPlaceUpdateRequestDto {
    @NotNull(message = "게시글 정보가 없습니다.")
    private long id;
    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 30, message = "제목은 30자 이하입니다.")
    private String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    @NotBlank(message = "우편번호를 입력해주세요.")
    @Size(max = 5, message = "우편번호는 5자 이하입니다.")
    private String zipcode;
    @NotBlank(message = "주소를 입력해주세요")
    private String mainAddress;
    @NotBlank(message = "상세주소를 입력해주세요")
    private String subAddress;
    @NotNull(message = "별점을 입력해주세요")
    private int rating;

    @Builder
    public HotPlaceUpdateRequestDto(long id, String title, String content, String zipcode, String mainAddress, String subAddress, int rating) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
        this.rating = rating;
    }
}
