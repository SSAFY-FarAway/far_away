package com.ssafy.faraway.domain.attraction.service;

import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.SidoGetResponseDto;
import com.ssafy.faraway.domain.attraction.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService{

    private final AttractionRepository attractionRepository;
    @Override
    public List<AttractionGetResponseDto> findAll() throws  Exception{
        return attractionRepository.findAll();
    }

    @Override
    public List<SidoGetResponseDto> findAllSido() throws  Exception{
        return attractionRepository.findAllSido();
    }


}
