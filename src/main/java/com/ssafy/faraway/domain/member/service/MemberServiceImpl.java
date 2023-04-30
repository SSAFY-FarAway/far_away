package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import com.ssafy.faraway.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import java.math.BigInteger;
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Integer save(MemberSaveRequestDto memberSaveRequestDto){ //이메일 인증 추가 예정 !
        String salt = getSalt();
        String encodedPwd = encrypt(memberSaveRequestDto.getLoginPwd(), salt);
        MemberSaveRequestDto encryptMember = MemberSaveRequestDto.builder()
                .loginId(memberSaveRequestDto.getLoginId())
                .loginPwd(encodedPwd)
                .lastName(memberSaveRequestDto.getLastName())
                .firstName(memberSaveRequestDto.getFirstName())
                .birth(memberSaveRequestDto.getBirth())
                .email(memberSaveRequestDto.getEmail())
                .zipcode(memberSaveRequestDto.getZipcode())
                .mainAddress(memberSaveRequestDto.getMainAddress())
                .subAddress(memberSaveRequestDto.getSubAddress())
                .salt(salt).build();
        return memberRepository.save(encryptMember);
    }

    @Override
    public MemberResponseDto find(Long id) throws SQLException {
        return memberRepository.find(id);
    }
    @Override
    public List<MemberListResponseDto> findAll() throws SQLException {
        return memberRepository.findAll();
    }

    @Transactional
    @Override
    public Integer update(MemberUpdateRequestDto memberUpdateRequestDto) throws SQLException {
        return memberRepository.update(memberUpdateRequestDto);
    }

    @Transactional
    @Override
    public Integer delete(Long id) throws SQLException {
        return memberRepository.delete(id);
    }

    public String getSalt() {
        String salt="";
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);
            salt = new String(Base64.getEncoder().encode(bytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return salt;
    }

    public String encrypt(String loginPwd, String hash) {
        String salt = hash+loginPwd;
        String hex = null;

        try {
            MessageDigest msg = MessageDigest.getInstance("SHA-512");
            msg.update(salt.getBytes());
            hex = String.format("%128x", new BigInteger(1, msg.digest()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hex;
    }

}
