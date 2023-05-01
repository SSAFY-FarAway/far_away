package com.ssafy.faraway.domain.hotplace.repository;

import com.ssafy.faraway.domain.hotplace.entity.HotPlace;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface HotPlaceRepository {
    Integer save(HotPlace hotPlace) throws SQLException;
}
