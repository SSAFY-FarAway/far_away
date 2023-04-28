package com.ssafy.faraway.domain.post.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostLike {
    private long postId;
    private long memberId;
    private LocalDateTime createdDate;
}
