package com.ssafy.faraway.domain.post.repository.old;

import com.ssafy.faraway.domain.post.dto.req.PostCommentUpdateRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostCommentListResponseDto;
import com.ssafy.faraway.domain.post.entity.PostComment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PostCommentRepository {
    Integer save(PostComment postComment) throws SQLException;
    List<PostCommentListResponseDto> findAllByPostId(long postId) throws SQLException;
    Integer update(PostCommentUpdateRequestDto postCommentUpdateRequestDto) throws SQLException;
    Integer delete(Long id) throws SQLException;
}