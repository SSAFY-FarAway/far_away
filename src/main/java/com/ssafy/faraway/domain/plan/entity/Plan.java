package com.ssafy.faraway.domain.plan.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Plan {
    private long id;
    private long memberId;
    private String title;
    private String content;
    private long hit;
    private String plan;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
