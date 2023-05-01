package com.ssafy.faraway.domain.member.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberEncryptedLoginRequestDto{


    @Builder
    public MemberEncryptedLoginRequestDto(String loginId, String encryptedLoginPwd) {
    }

    public MemberEncryptedLoginRequestDto toDto(MemberLoginRequestDto memberLoginRequestDto, String encodedPwd){
        return MemberEncryptedLoginRequestDto.builder()
                .loginId(memberLoginRequestDto.getLoginId())
                .encryptedLoginPwd(encodedPwd)
                .build();
    }
}
