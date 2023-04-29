package com.ssafy.faraway.domain.member.repository;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
    Integer save(MemberSaveRequestDto memberSaveRequestDto);

    MemberResponseDto find(String id);

    MemberListResponseDto findAll();

    Integer update(MemberUpdateRequestDto memberUpdateRequestDto);

    Integer delete(Long id);
}
