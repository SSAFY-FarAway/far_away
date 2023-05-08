package com.ssafy.faraway.domain.post.repository.old;

import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostUpdateRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostResponseDto;
import com.ssafy.faraway.domain.post.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PostRepository {

    Integer save(Post post) throws SQLException;
    List<PostListResponseDto> findAllByCondition(SearchCondition searchCondition) throws SQLException;
    Integer getTotalCount(SearchCondition searchCondition) throws SQLException;
    PostResponseDto findById(Long id) throws SQLException;
    Integer updateHit(Long id) throws SQLException;
    Integer update(PostUpdateRequestDto postUpdateRequestDto) throws SQLException;
    Integer delete(Long id) throws SQLException;
}
