package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.domain.plan.dto.req.PlanCommentSaveRequestDto;

public interface PlanCommentService {

    int save(PlanCommentSaveRequestDto planCommentSaveRequestDto) throws Exception;

    int delete(Long id) throws Exception;
}
