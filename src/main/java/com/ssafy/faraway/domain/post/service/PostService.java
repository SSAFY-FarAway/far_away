package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.common.PostSearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.req.PostUpdateRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostResponseDto;

import java.util.List;

public interface PostService {

    Integer save(PostSaveRequestDto postSaveRequestDto) throws Exception;
    List<PostListResponseDto> findAllByCondition(PostSearchCondition postSearchCondition) throws Exception;
    PostResponseDto findById(Long id) throws Exception;
    Integer update(PostUpdateRequestDto postUpdateRequestDto) throws Exception;
    Integer delete (Long id) throws Exception;
}
