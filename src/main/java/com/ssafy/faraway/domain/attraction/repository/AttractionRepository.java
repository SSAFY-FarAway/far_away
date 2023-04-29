package com.ssafy.faraway.domain.attraction.repository;

import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttractionRepository {
    List<AttractionGetResponseDto> findAll();
}
