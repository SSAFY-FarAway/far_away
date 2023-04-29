package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    List<MemberListResponseDto> findAll() throws SQLException;
    Integer save(MemberSaveRequestDto memberSaveRequestDto)throws SQLException;
}
