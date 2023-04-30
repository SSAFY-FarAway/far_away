package com.ssafy.faraway.domain.member.dto.req;

import com.ssafy.faraway.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginRequestDto {
    private String loginId;
    private String loginPwd;


    @Builder
    public MemberLoginRequestDto(String loginId, String loginPwd) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }


    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .loginPwd(loginPwd)
                .build();
    }
}

