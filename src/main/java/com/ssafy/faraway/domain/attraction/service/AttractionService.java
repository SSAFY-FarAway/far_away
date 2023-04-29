package com.ssafy.faraway.domain.attraction.service;

import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;

import java.util.List;

public interface AttractionService {

    public List<AttractionGetResponseDto> findAll();
}
