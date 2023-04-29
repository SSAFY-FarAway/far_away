package com.ssafy.faraway.domain.member.repository;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface MemberRepository {

    // regist member
    int save(MemberSaveRequestDto memberSaveRequestDto) throws SQLException;

}
