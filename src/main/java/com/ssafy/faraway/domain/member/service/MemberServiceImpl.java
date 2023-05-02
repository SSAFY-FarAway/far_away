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
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Integer save(MemberSaveRequestDto memberSaveRequestDto){ //이메일 인증 추가 예정 !
        String salt = getSalt();
        String encodedPwd = encrypt(memberSaveRequestDto.getLoginPwd(), salt);
        MemberSaveRequestDto memberEncryptedSaveRequestDto = new MemberSaveRequestDto().toDto(memberSaveRequestDto,encodedPwd, salt);
        System.out.println(memberEncryptedSaveRequestDto);
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

    @Override
    public Integer loginPwdUpdate(MemberLoginPwdUpdateRequestDto memberLoginPwdUpdateRequestDto) throws SQLException {
        // 암호화된 원래 비밀번호
        String encodedOriginalLoginPwd = memberRepository.findLoginPwdById(memberLoginPwdUpdateRequestDto.getId());

        // 1. 원래 비밀번호가 맞는지 체크
        if(!checkPwd(memberLoginPwdUpdateRequestDto.getId(), memberLoginPwdUpdateRequestDto.getOriginalLoginPwd())){
            return null; // 원래 비밀번호 안맞으면 null 리턴
        }
        // salt
        String salt = memberRepository.findSaltById(memberLoginPwdUpdateRequestDto.getId());
        // 새로운 비밀번호 암호화
        String encodedChangeLoginPwd = encrypt(memberLoginPwdUpdateRequestDto.getChangeLoginPwd(), salt);

        // 멤버변수에 암호화된 비밀번호를 넣은 DTO
        MemberLoginPwdUpdateRequestDto memberEncryptedLoginPwdUpdateRequestDto = new MemberLoginPwdUpdateRequestDto()
                .toDto(memberLoginPwdUpdateRequestDto, encodedOriginalLoginPwd, encodedChangeLoginPwd);
        return memberRepository.loginPwdUpdate(memberEncryptedLoginPwdUpdateRequestDto);
    }

    @Transactional
    @Override
    public Integer delete(Long id, String loginPwd) throws SQLException {
        if(!checkPwd(id, loginPwd)){ // 같지 않으면
            return null;
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
        MemberLoginRequestDto memberEncryptedLoginRequestDto = new MemberLoginRequestDto().toDto(memberLoginRequestDto,encodedPwd);
        return memberRepository.findByLoginIdAndLoginPwd(memberEncryptedLoginRequestDto);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer loginIdCheck(String loginId) throws SQLException {
        return memberRepository.loginIdCheck(loginId);
    }
    @Transactional(readOnly = true)
    @Override
    public boolean loginPwdCheck(Long id, String loginPwd) throws SQLException {
        return checkPwd(id, loginPwd);
    }

    @Override
    public String findLoginIdByEmailAndBirth(Map<String, String> map) {
        return memberRepository.findLoginIdByEmailAndBirth(map);
    }

    @Override
    public String findLoginPwd(Map<String, String> map) throws SQLException {
        if(memberRepository.findLoginPwd(map) == null){
            return null;
        }
        // 새로운 비밀번호를 00000000 ( 0 x 8) 으로 초기화 하고 암호화 한 후 집어넣어줘야함 !
        String newLoginPwd = "00000000";
        String salt = getSalt();
        String encodedNewLoginPwd = encrypt(newLoginPwd , salt);
        map.put("loginPwd", encodedNewLoginPwd);
        map.put("salt", salt);
        memberRepository.updateLoginPwdToZero(map);
        return newLoginPwd;
    }

    public boolean checkPwd(Long id, String loginPwd){
        //원래 비밀번호
        String originalLoginPwd = memberRepository.findLoginPwdById(id);
        String encryptedLoginPwd = encrypt(loginPwd, memberRepository.findSaltById(id));
        if(!originalLoginPwd.equals(encryptedLoginPwd)){
            return false; // different
        }
        return true; // same
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
