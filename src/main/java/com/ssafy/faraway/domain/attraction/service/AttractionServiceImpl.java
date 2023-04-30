package com.ssafy.faraway.domain.attraction.service;

import com.ssafy.faraway.domain.attraction.dto.req.AttractionGetRequestDto;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.GugunGetResponseDto;
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

    @Override
    public List<GugunGetResponseDto> findAllGugun(int sidoCode) throws Exception {
        return attractionRepository.findAllGugun(sidoCode);
    }

    @Override
    public List<AttractionGetResponseDto> findAttractionBySidoCodeAndGugunCodeAndContentTypeId(AttractionGetRequestDto attractionGetRequestDto) throws Exception {
        return attractionRepository.findAttractionBySidoCodeAndGugunCodeAndContentTypeId(attractionGetRequestDto);
    }

    @Override
    public List<AttractionGetResponseDto> findAllByIds(List<Long> attractions) throws Exception {
        System.out.println(attractions);
        return attractionRepository.findAllByIds(attractions);
    }


}
