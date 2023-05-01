package com.ssafy.faraway.domain.hotplace.repository;

import com.ssafy.faraway.domain.hotplace.entity.HotPlaceComment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface HotPlaceCommentRepository {
    Integer save(HotPlaceComment hotPlaceComment) throws SQLException;
}
