package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    Integer save(MemberSaveRequestDto memberSaveRequestDto);
    Integer update(MemberUpdateRequestDto memberUpdateRequestDto);

    Integer delete(Long id);
}
