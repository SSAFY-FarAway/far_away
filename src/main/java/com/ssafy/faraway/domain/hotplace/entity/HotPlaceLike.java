package com.ssafy.faraway.domain.hotplace.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HotPlaceLike {
    private long hotPlaceId;
    private long memberId;
    private LocalDateTime createdDate;
}
