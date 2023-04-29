package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;

import java.sql.SQLException;

public interface MemberService {
    int save(MemberSaveRequestDto memberSaveRequestDto) throws SQLException;
}
