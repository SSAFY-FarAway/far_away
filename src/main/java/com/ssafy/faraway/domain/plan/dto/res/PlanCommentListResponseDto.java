package com.ssafy.faraway.domain.plan.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class PlanCommentListResponseDto {
    private Long id;
    private Long planId;
    private Long memberId;
    private String loginId;
    private String content;
    private LocalDateTime createdDate;

}
