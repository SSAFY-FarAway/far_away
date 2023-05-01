package com.ssafy.faraway.domain.plan.repository;

import com.ssafy.faraway.domain.plan.dto.req.PlanCommentSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanCommentUpdateRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanCommentListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PlanCommentRepository {
    int save(PlanCommentSaveRequestDto planCommentSaveRequestDto) throws SQLException;

    int delete(Long id) throws SQLException;

    List<PlanCommentListResponseDto> findCommentByPlanId(Long id) throws SQLException;

    int update(PlanCommentUpdateRequestDto planCommentUpdateRequestDto) throws SQLException;
}
