package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl {
    private final MemberRepository memberRepository;

    @Transactional
    public Integer save(MemberSaveRequestDto memberSaveRequestDto){
        return memberRepository.save(memberSaveRequestDto);
    }

}
