package com.ssafy.faraway.domain.attraction.service;

import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.SidoGetResponseDto;

import java.util.List;

public interface AttractionService {

    List<AttractionGetResponseDto> findAll() throws Exception;
    List<SidoGetResponseDto> findAllSido() throws  Exception;

}
