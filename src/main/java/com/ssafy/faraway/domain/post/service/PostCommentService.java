package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.domain.post.dto.req.PostCommentSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.req.PostCommentUpdateRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostCommentListResponseDto;

import java.util.List;

public interface PostCommentService {
    Integer save(PostCommentSaveRequestDto postCommentSaveRequestDto) throws Exception;
    List<PostCommentListResponseDto> findAllByPostId(long postId) throws Exception;
    Integer update(PostCommentUpdateRequestDto postCommentUpdateRequestDto) throws Exception;
    Integer delete(Long id) throws Exception;
}
