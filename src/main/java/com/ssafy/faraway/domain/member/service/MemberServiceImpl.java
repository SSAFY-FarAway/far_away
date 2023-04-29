package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import com.ssafy.faraway.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Integer save(MemberSaveRequestDto memberSaveRequestDto){
        return memberRepository.save(memberSaveRequestDto);
    }

    @Override
    public MemberResponseDto find(String id) throws SQLException {
        return memberRepository.find(id);
    }

    @Override
    public MemberListResponseDto findAll() throws SQLException {
        return memberRepository.findAll();
    }

    @Transactional
    @Override
    public Integer delete(Long id) throws SQLException {
        return memberRepository.delete(id);
    }

    @Transactional
    @Override
    public Integer update(MemberUpdateRequestDto memberUpdateRequestDto) throws SQLException {
        return memberRepository.update(memberUpdateRequestDto);
    }
}
