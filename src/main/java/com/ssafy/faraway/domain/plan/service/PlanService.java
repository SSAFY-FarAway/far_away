package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import org.springframework.stereotype.Service;

public interface PlanService {
    int save(PlanSaveRequestDto planSaveRequestDto) throws Exception;
}
