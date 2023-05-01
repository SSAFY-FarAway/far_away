package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.domain.plan.dto.req.PlanCommentSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanCommentListResponseDto;
import com.ssafy.faraway.domain.plan.repository.PlanCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanCommentServiceImpl implements PlanCommentService{
    private final PlanCommentRepository planCommentRepository;
    @Override
    public int save(PlanCommentSaveRequestDto planCommentSaveRequestDto) throws Exception {
        return planCommentRepository.save(planCommentSaveRequestDto);
    }

    @Override
    public int delete(Long id) throws Exception {
        return planCommentRepository.delete(id);
    }

    @Override
    public List<PlanCommentListResponseDto> findCommentByPlanId(Long id) throws Exception {
        return planCommentRepository.findCommentByPlanId(id);
    }
}
