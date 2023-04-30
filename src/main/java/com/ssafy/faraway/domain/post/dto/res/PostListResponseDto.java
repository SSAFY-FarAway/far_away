package com.ssafy.faraway.domain.post.dto.res;

import com.ssafy.faraway.domain.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostListResponseDto {
    private long id;
    private long memberId;
    private String memberName;
    private String category;
    private String title;
    private long hit;
    private LocalDateTime modifiedDate;
}