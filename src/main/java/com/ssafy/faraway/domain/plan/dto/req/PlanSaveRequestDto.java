package com.ssafy.faraway.domain.plan.dto.req;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlanSaveRequestDto {
    // TODO: 세션에서 받아온 loginId를 기반으로 memberId(pk)를 받아서 지정해주기
    private Long memberId;
    // TODO: notnull 조건 추가 필요 (validation)
    private Long id; // planId;
    private String title;
    private String content;
    private String plan;
}

