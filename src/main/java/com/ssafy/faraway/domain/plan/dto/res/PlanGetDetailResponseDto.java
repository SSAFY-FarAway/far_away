package com.ssafy.faraway.domain.plan.dto.res;

import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanGetDetailResponseDto {
    private Long id;
    private String title;
    private String content;
    private String loginId;
    private Long hit;
    private List<AttractionGetResponseDto> attractionList = new ArrayList<>();
    private int[] shortestPathList;


    public PlanGetDetailResponseDto toDto(PlanGetDetailDto planGetDetailDto,
                                          List<AttractionGetResponseDto> attractionList,
                                          int[] shortestPath) {
        return PlanGetDetailResponseDto.builder()
                .id(planGetDetailDto.getId())
                .title(planGetDetailDto.getTitle())
                .content(planGetDetailDto.getContent())
                .loginId(planGetDetailDto.getLoginId())
                .hit(planGetDetailDto.getHit())
                .attractionList(attractionList)
                .shortestPathList(shortestPath)
                .build();
    }
}
