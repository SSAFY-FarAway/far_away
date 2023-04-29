package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import com.ssafy.faraway.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;
//    private JavaMailSender javaMailSender; // 메일 전송용


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int save(MemberSaveRequestDto memberSaveRequestDto) throws SQLException {
        return memberRepository.save(memberSaveRequestDto);
    }
}
