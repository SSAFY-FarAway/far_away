package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;
import com.ssafy.faraway.domain.plan.repository.PlanRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{
    private final PlanRepository planRepository;
    @Override
    public int save(PlanSaveRequestDto planSaveRequestDto) throws Exception {
        return planRepository.save(planSaveRequestDto);
    }

    @Override
    public List<PlanGetResponseDto> findAllByCondition(PlanSearchCondition planSearchCondition) throws Exception {
        return planRepository.findAllByCondition(planSearchCondition);
    }
}
