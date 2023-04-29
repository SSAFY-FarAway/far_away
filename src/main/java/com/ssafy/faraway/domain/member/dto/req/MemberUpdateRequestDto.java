package com.ssafy.faraway.domain.member.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private String loginPwd;
    private String lastName;
    private String firstName;
    private String birth;
    private String email;
    private String zipcode;
    private String mainAddress;
    private String subAddress;

    @Builder
    public MemberUpdateRequestDto(String loginPwd, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress) {
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
