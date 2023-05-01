package com.ssafy.faraway.domain.hotplace.repository;

import com.ssafy.faraway.domain.hotplace.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface FileInfoRepository {
    Integer save(List<FileInfo> list) throws SQLException;
}
