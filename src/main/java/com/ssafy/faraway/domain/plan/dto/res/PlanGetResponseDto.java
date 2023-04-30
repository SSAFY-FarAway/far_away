package com.ssafy.faraway.domain.plan.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlanGetResponseDto {
    private Long id;
    private String title;
    private String loginId;
    private int hit;
    private LocalDateTime createdDate;
}
