package com.ssafy.faraway.domain.member.dto.req;

import com.ssafy.faraway.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String loginId;
    private String loginPwd;
    private String lastName;
    private String firstName;
    private String birth;
    private String email;
    private String zipcode;

    private String mainAddress;
    private String subAddress;
    private String salt;

    @Builder
    public MemberSaveRequestDto(String loginId, String loginPwd, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress, String salt) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.email = email;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
        this.salt = salt;
    }

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .loginPwd(loginPwd)
                .lastName(lastName)
                .firstName(firstName)
                .birth(birth)
                .email(email)
                .zipcode(zipcode)
                .mainAddress(mainAddress)
                .subAddress(subAddress)
                .salt(salt)
                .build();
    }
}
