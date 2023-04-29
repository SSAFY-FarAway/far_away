package com.ssafy.faraway.domain.attraction.dto.res;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AttractionGetResponseDto {
    private Long contentId;
    private String title;
    private String addr1;
    private String zipcode;
    private String tel;
    private String firstImage;
    private int latitude;
    private int longitude;
    private String sidoName;
    private String gugunName;


}
