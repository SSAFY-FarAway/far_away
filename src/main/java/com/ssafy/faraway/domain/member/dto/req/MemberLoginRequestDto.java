package com.ssafy.faraway.domain.member.dto.req;

import com.ssafy.faraway.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class MemberLoginRequestDto {
    @NotEmpty(message = "loginId ust not be empty")
    @Size(min = 6, max = 20)
    private String loginId;
    @NotEmpty(message = "loginPwd must not be empty")
    @Size(min=8)
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
