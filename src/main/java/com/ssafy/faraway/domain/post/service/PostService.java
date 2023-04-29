package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.common.PostSearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;

import java.util.List;

public interface PostService {

    Integer save(PostSaveRequestDto postSaveRequestDto) throws Exception;
    List<PostListResponseDto> findAllByCondition(PostSearchCondition postSearchCondition) throws Exception;
}
