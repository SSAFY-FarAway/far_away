package com.ssafy.faraway.domain.plan.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PlanCommentSaveRequestDto {
    private long planId;
    private long memberId;
    private String content;
}
