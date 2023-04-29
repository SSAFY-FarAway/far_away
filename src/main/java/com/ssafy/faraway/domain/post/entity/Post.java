package com.ssafy.faraway.domain.post.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class Post {
    private long id;
    private long memberId;
    private String category;
    private String title;
    private String content;
    private long hit;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public Post(long memberId, String category, String title, String content) {
        this.memberId = memberId;
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
