package com.ssafy.faraway.domain.plan.repository;

import com.ssafy.faraway.domain.plan.dto.req.PlanCommentSaveRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface PlanCommentRepository {
    int save(PlanCommentSaveRequestDto planCommentSaveRequestDto) throws SQLException;

    int delete(Long id) throws SQLException;
}
