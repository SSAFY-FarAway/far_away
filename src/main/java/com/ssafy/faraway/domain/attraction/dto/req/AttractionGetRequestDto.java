package com.ssafy.faraway.domain.attraction.dto.req;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttractionGetRequestDto {
    private int sidoCode;
    private int gugunCode;
    private int contentTypeId;

}
