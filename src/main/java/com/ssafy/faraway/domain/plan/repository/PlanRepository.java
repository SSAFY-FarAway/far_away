package com.ssafy.faraway.domain.plan.repository;

import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanUpdateRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PlanRepository {
    int save(PlanSaveRequestDto planSaveRequestDto) throws SQLException;
    List<PlanGetResponseDto> findAllByCondition(PlanSearchCondition planSearchCondition) throws SQLException;
    PlanGetDetailDto findById(Long id) throws SQLException;

    int updateHit(Long id) throws SQLException;

    int updatePlan(PlanUpdateRequestDto planUpdateRequestDto) throws SQLException;

    int deletePlan(Long id) throws SQLException;

}
