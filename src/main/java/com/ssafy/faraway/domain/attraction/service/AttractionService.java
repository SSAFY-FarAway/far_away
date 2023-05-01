package com.ssafy.faraway.domain.attraction.service;

import com.ssafy.faraway.domain.attraction.dto.req.AttractionGetRequestDto;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.GugunGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.SidoGetResponseDto;

import java.util.List;

public interface AttractionService {

    List<AttractionGetResponseDto> findAll() throws Exception;
    List<SidoGetResponseDto> findAllSido() throws  Exception;
    List<GugunGetResponseDto> findAllGugun(int sidoCode) throws Exception;
    List<AttractionGetResponseDto> findAttractionBySidoCodeAndGugunCodeAndContentTypeId(AttractionGetRequestDto attractionGetRequestDto) throws Exception;
    List<AttractionGetResponseDto> findAllByIds(List<Long> attractions) throws Exception;
}
