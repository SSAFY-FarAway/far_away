package com.ssafy.faraway.domain.member.service;

import com.ssafy.faraway.domain.member.dto.req.*;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberLoginResponseDto;
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
        MemberEncryptedSaveRequestDto memberEncryptedSaveRequestDto = new MemberEncryptedSaveRequestDto().toDto(memberSaveRequestDto,encodedPwd, salt);
        return memberRepository.save(memberEncryptedSaveRequestDto);
    }
    @Transactional(readOnly = true)
    @Override
    public MemberResponseDto findById(Long id) throws SQLException {
        return memberRepository.findById(id);
    }
    @Transactional(readOnly = true)
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
    public Integer delete(Long id, String loginPwd) throws SQLException {
        // 원본 암호화 패스워드
        String originalLoginPwd = memberRepository.findLoginPwdById(id);
        String encryptedLoginPwd = encrypt(loginPwd, memberRepository.findSaltById(id));
        if(originalLoginPwd != encryptedLoginPwd){
            return null; // 실패
        }
        return memberRepository.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public MemberLoginResponseDto findByLoginIdAndLoginPwd(MemberLoginRequestDto memberLoginRequestDto) throws SQLException {
        Long id = memberRepository.findIdByLoginId(memberLoginRequestDto.getLoginId());
//        if(memberRepository.certified(id) == 0){  // 이메일 인증 완료 후 주석 처리 해제 !!
//            return null;
//        }
        String salt = memberRepository.findSaltById(id);
        String encodedPwd = encrypt(memberLoginRequestDto.getLoginPwd(), salt);
        MemberEncryptedLoginRequestDto memberEncryptedLoginRequestDto = new MemberEncryptedLoginRequestDto().toDto(memberLoginRequestDto,encodedPwd);
        return memberRepository.findByLoginIdAndLoginPwd(memberEncryptedLoginRequestDto);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer loginIdCheck(String loginId) throws SQLException {
        return memberRepository.loginIdCheck(loginId);
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
