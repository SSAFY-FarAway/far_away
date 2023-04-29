package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;

import java.sql.SQLException;

public interface MemberService {
    Integer save(MemberSaveRequestDto memberSaveRequestDto) throws SQLException;

    MemberResponseDto find(String id) throws SQLException;

    MemberListResponseDto findAll() throws SQLException;

    Integer update(MemberUpdateRequestDto memberUpdateRequestDto) throws SQLException;

    Integer delete(String id) throws SQLException;
}
