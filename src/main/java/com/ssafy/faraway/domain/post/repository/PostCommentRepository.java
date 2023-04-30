package com.ssafy.faraway.domain.post.repository;

import com.ssafy.faraway.domain.post.entity.PostComment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface PostCommentRepository {
    Integer save(PostComment postComment) throws SQLException;
}
