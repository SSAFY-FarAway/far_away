package com.ssafy.faraway.domain.plan.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PlanLike {
    private long planId;
    private long memberId;
    private LocalDateTime createdDate;
}
