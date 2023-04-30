package com.ssafy.faraway.domain.member.dto.req;

import com.ssafy.faraway.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {
    @NotEmpty(message = "loginId ust not be empty")
    @Size(min = 6, max = 20)
    private String loginId;
    @NotEmpty(message = "loginPwd must not be empty")
    @Size(min=8)
    private String loginPwd;
    @NotEmpty(message = "lastName must not be empty")
    @Size(max=20)
    private String lastName;
    @NotEmpty(message = "firstName must not be empty")
    @Size(max=30)
    private String firstName;
    @NotEmpty(message = "birth's size must not be 6")
    @Size(min=6, max=6)
    private String birth;
    @NotEmpty(message = "email must not be empty")
    @Email
    private String email;
    @NotEmpty(message = "zipcode's size must not be 6")
    @Size(min=5, max=5)
    private String zipcode;
    @NotEmpty(message = "mainAddress must not be empty")
    private String mainAddress;
    @NotEmpty(message = "subAddress must not be empty")
    private String subAddress;
    @NotEmpty(message = "salt must not be empty")
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

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
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