package com.ssafy.faraway.domain.plan.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PlanCommentUpdateRequestDto {
    private Long id;
    private String content;
}
