package com.ssafy.faraway.domain.member.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@ToString
public class MemberPwdCheckDto {
    private Long id;
    @Size(min=8)
    private String loginPwd; // 바뀔 비밀번호

    @Builder
    public MemberPwdCheckDto(Long id, String loginPwd){
        this.id = id;
        this.loginPwd = loginPwd;
    }

    public MemberPwdCheckDto toDto(MemberPwdCheckDto memberPwdCheckDto){
        return MemberPwdCheckDto.builder()
                .id(id)
                .loginPwd(loginPwd)
                .build();
    }
}
