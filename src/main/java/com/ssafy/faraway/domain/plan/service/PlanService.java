package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanUpdateRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;

import java.util.List;

public interface PlanService {
    int save(PlanSaveRequestDto planSaveRequestDto) throws Exception;
    PagingResponse<PlanGetResponseDto> findAllByCondition(SearchCondition searchCondition) throws Exception;
    PlanGetDetailDto findById(Long id) throws Exception;

    int[] getShortestPath(List<AttractionGetResponseDto> attractionList);

    int updateHit(Long id) throws Exception;
    int updatePlan(PlanUpdateRequestDto planUpdateRequestDto) throws Exception;

    int deletePlan(Long id) throws Exception;

}
