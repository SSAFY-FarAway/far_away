package com.ssafy.faraway.domain.post.repository;

import com.ssafy.faraway.common.PostSearchCondition;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostResponseDto;
import com.ssafy.faraway.domain.post.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PostRepository {

    Integer save(Post post) throws SQLException;
    List<PostListResponseDto> findAllByCondition(PostSearchCondition postSearchCondition) throws SQLException;
    PostResponseDto findById(Long id) throws SQLException;
    Integer delete(Long id) throws SQLException;
}
