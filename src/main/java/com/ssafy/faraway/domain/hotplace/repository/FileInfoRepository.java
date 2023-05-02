package com.ssafy.faraway.domain.hotplace.repository;

import com.ssafy.faraway.domain.hotplace.dto.res.FileInfoListResponseDto;
import com.ssafy.faraway.domain.hotplace.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface FileInfoRepository {
    Integer save(List<FileInfo> list) throws SQLException;
    List<FileInfoListResponseDto> findAllFileInfoByHotPlaceId(long hotPlaceId) throws SQLException;
    Integer delete(long id) throws SQLException;
    Integer deleteFileInfoByHotPlaceId(long hotPlaceId) throws SQLException;
}
