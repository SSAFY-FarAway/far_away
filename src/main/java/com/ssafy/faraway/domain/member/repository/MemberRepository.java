package com.ssafy.faraway.domain.member.repository;

import com.ssafy.faraway.domain.member.dto.req.MemberLoginRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberLoginResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MemberRepository {
    MemberResponseDto find(Long id);
    List<MemberListResponseDto> findAll();
    Integer save(MemberSaveRequestDto memberSaveRequestDto);

    Integer update(MemberUpdateRequestDto memberUpdateRequestDto) ;
    Integer delete(Long id);
    String salt(Long id);
    Long id(String loginId);
    int certified(Long id);
    MemberLoginResponseDto login(MemberLoginRequestDto memberLoginRequestDto);



}
