package com.ssafy.faraway.domain.attraction.dto.req;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttractionGetRequestDto {
    private Integer sidoCode;
    private Integer gugunCode;
    private Integer contentTypeId;

}
