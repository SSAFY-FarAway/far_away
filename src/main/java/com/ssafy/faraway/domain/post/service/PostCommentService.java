package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.domain.post.dto.req.PostCommentSaveRequestDto;

public interface PostCommentService {
    Integer save(PostCommentSaveRequestDto postCommentSaveRequestDto) throws Exception;
}
