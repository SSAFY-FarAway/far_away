package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.domain.plan.dto.req.PlanCommentSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanCommentListResponseDto;

import java.util.List;

public interface PlanCommentService {

    int save(PlanCommentSaveRequestDto planCommentSaveRequestDto) throws Exception;

    int delete(Long id) throws Exception;

    List<PlanCommentListResponseDto> findCommentByPlanId(Long id) throws Exception;
}
