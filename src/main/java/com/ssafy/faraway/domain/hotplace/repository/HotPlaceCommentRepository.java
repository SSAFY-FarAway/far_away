package com.ssafy.faraway.domain.hotplace.repository;

import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceCommentListResponseDto;
import com.ssafy.faraway.domain.hotplace.entity.HotPlaceComment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface HotPlaceCommentRepository {
    Integer save(HotPlaceComment hotPlaceComment) throws SQLException;
    List<HotPlaceCommentListResponseDto> findAllByHotPlaceId(Long id) throws SQLException;
}
