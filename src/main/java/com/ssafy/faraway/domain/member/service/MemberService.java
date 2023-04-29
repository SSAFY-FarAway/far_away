package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;

public interface MemberService {
    Integer save(MemberSaveRequestDto memberSaveRequestDto);
}
