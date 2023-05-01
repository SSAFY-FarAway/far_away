package com.ssafy.faraway.domain.plan.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanUpdateRequestDto {
    private Long id;
    private String title;
    private String content;
    private String plan;
}
