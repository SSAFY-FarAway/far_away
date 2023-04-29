package com.ssafy.faraway.domain.attraction.repository;

import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.SidoGetResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionRepository {
    List<AttractionGetResponseDto> findAll() throws SQLException;
    List<SidoGetResponseDto> findAllSido() throws SQLException;

}
