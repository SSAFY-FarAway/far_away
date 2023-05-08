package com.ssafy.faraway.domain.post.repository;

import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {
    Page<PostListResponseDto> findAllBySearchCondition(SearchCondition searchCondition, Pageable pageable);
}
