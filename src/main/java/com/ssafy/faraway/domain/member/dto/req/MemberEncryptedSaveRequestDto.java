package com.ssafy.faraway.domain.member.dto.req;

import com.ssafy.faraway.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@ToString
public class MemberEncryptedSaveRequestDto {
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
    public MemberEncryptedSaveRequestDto(String loginId, String loginPwd, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress, String salt) {
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

    public MemberEncryptedSaveRequestDto toDto(MemberSaveRequestDto memberSaveRequestDto, String encodedPwd, String salt) {
        return MemberEncryptedSaveRequestDto.builder()
                .loginId(memberSaveRequestDto.getLoginId())
                .loginPwd(encodedPwd)
                .lastName(memberSaveRequestDto.getLastName())
                .firstName(memberSaveRequestDto.getFirstName())
                .birth(memberSaveRequestDto.getBirth())
                .email(memberSaveRequestDto.getEmail())
                .zipcode(memberSaveRequestDto.getZipcode())
                .mainAddress(memberSaveRequestDto.getMainAddress())
                .subAddress(memberSaveRequestDto.getSubAddress())
                .salt(salt)
                .build();
    }

}


