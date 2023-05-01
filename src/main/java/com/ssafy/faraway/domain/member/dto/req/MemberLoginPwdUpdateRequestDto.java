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
public class MemberLoginPwdUpdateRequestDto {
    private Long id;
    @NotEmpty(message = "loginPwd must not be empty")
    @Size(min=8)
    private String originalLoginPwd; //기존 비밀번호
    @NotEmpty(message = "loginPwd must not be empty")
    @Size(min=8)
    private String changeLoginPwd; // 바뀔 비밀번호

    @Builder
    public MemberLoginPwdUpdateRequestDto(Long id, String originalLoginPwd, String changeLoginPwd){
        this.id = id;
        this.originalLoginPwd = originalLoginPwd;
        this.changeLoginPwd = changeLoginPwd;
    }

    public MemberLoginPwdUpdateRequestDto toDto(MemberLoginPwdUpdateRequestDto memberLoginPwdUpdateRequestDto, String originalEncodedPwd, String changeEncodedPwd){
        return MemberLoginPwdUpdateRequestDto.builder()
                .id(memberLoginPwdUpdateRequestDto.getId())
                .originalLoginPwd(originalEncodedPwd)
                .changeLoginPwd(changeEncodedPwd)
                .build();
    }
}
