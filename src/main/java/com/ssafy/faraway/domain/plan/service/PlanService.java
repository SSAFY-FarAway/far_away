package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;

import java.util.List;

public interface PlanService {
    int save(PlanSaveRequestDto planSaveRequestDto) throws Exception;
    List<PlanGetResponseDto> findAllByCondition(PlanSearchCondition planSearchCondition) throws Exception;
    PlanGetDetailDto findById(Long id) throws Exception;

    List<Long> getShortestPath(List<AttractionGetResponseDto> attractionList);
}
