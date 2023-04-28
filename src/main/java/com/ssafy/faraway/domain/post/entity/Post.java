package com.ssafy.faraway.domain.post.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Post {
    private long id;
    private long memberId;
    private String category;
    private String title;
    private String content;
    private long hit;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
