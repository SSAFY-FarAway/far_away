package com.ssafy.faraway.domain.member.repository;

import com.ssafy.faraway.domain.member.dto.req.*;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberLoginResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface MemberRepository {
    MemberResponseDto findById(Long id);
    List<MemberListResponseDto> findAll();
    Integer save(MemberEncryptedSaveRequestDto memberEncryptedSaveRequestDto);

    Integer update(MemberUpdateRequestDto memberUpdateRequestDto) ;
    Integer delete(Long id);
    String findSaltById(Long id);
    Long findIdByLoginId(String loginId);
    Integer findCertifiedById(Long id);
    MemberLoginResponseDto findByLoginIdAndLoginPwd(MemberEncryptedLoginRequestDto memberEncryptedLoginRequestDto);

    Integer loginIdCheck(String loginId);

    Integer loginPwdCheck(Map<String, Object> map); // null == not equal

    String findLoginPwdById(Long id); // 암호화 된 pwd


}
