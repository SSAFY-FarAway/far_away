package com.ssafy.faraway.domain.post.repository;

import com.ssafy.faraway.common.PostSearchCondition;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PostRepository {

    List<PostListResponseDto> findAllByCondition(PostSearchCondition postSearchCondition) throws SQLException;
}
