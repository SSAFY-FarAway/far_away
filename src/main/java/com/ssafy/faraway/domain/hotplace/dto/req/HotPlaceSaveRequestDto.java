package com.ssafy.faraway.domain.hotplace.dto.req;

import com.ssafy.faraway.domain.hotplace.entity.HotPlace;
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
public class HotPlaceSaveRequestDto {
    @NotNull(message = "사용자 정보가 없습니다.")
    private long memberId;
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
    public HotPlaceSaveRequestDto(long memberId, String title, String content, String zipcode, String mainAddress, String subAddress, int rating) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
        this.rating = rating;
    }

    public HotPlace toEntity() {
        return HotPlace.builder()
                .memberId(memberId)
                .title(title)
                .content(content)
                .zipcode(zipcode)
                .mainAddress(mainAddress)
                .subAddress(subAddress)
                .rating(rating)
                .build();
    }
}
