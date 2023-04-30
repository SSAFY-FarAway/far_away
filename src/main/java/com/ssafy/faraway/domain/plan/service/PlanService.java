package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlanService {
    int save(PlanSaveRequestDto planSaveRequestDto) throws Exception;
    List<PlanGetResponseDto> findAllByCondition(PlanSearchCondition planSearchCondition) throws Exception;
}
