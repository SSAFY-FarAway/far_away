package com.ssafy.faraway.domain.plan.repository;

import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface PlanRepository {
    int save(PlanSaveRequestDto planSaveRequestDto) throws SQLException;


}
