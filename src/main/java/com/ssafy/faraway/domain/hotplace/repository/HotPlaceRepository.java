package com.ssafy.faraway.domain.hotplace.repository;

import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceUpdateRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceListResponseDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceResponseDto;
import com.ssafy.faraway.domain.hotplace.entity.HotPlace;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface HotPlaceRepository {
    Integer save(HotPlace hotPlace) throws SQLException;
    HotPlaceResponseDto findById(Long id) throws SQLException;
    Integer updateHit(Long id) throws SQLException;
    List<HotPlaceListResponseDto> findAllByCondition(SearchCondition searchCondition) throws SQLException;
    Integer getTotalCount(SearchCondition searchCondition) throws SQLException;
    Integer update(HotPlaceUpdateRequestDto hotPlaceUpdateRequestDto) throws SQLException;
    Integer delete(Long id) throws SQLException;
}
