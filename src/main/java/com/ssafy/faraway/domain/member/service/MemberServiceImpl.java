package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Integer save(MemberSaveRequestDto memberSaveRequestDto){
        return memberRepository.save(memberSaveRequestDto);
    }

    @Transactional
    @Override
    public Integer update(MemberUpdateRequestDto memberUpdateRequestDto) {
        return memberRepository.update(memberUpdateRequestDto);
    }

    @Transactional
    @Override
    public Integer delete(Long id) {
        return memberRepository.delete(id);
    }


}
