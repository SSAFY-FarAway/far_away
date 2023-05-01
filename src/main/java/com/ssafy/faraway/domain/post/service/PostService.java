package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.req.PostUpdateRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostResponseDto;

public interface PostService {

    Integer save(PostSaveRequestDto postSaveRequestDto) throws Exception;

    PagingResponse<PostListResponseDto> findAllByCondition(SearchCondition searchCondition) throws Exception;

    PostResponseDto findById(Long id) throws Exception;

    Integer updateHit(Long id) throws Exception;

    Integer update(PostUpdateRequestDto postUpdateRequestDto) throws Exception;

    Integer delete(Long id) throws Exception;
}
