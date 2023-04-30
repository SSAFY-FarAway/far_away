package com.ssafy.faraway.domain.member.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private Long id;
    private String loginPwd;
    private String lastName;
    private String firstName;
    private String birth;
    private String email;
    private String zipcode;
    private String mainAddress;
    private String subAddress;

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Builder
    public MemberUpdateRequestDto(Long id, String loginPwd, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress) {
        this.id = id;
        this.loginPwd = loginPwd;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.email = email;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
    }
}
