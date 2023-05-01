package com.ssafy.faraway.domain.member.dto.req;

import com.ssafy.faraway.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class MemberEncryptedSaveRequestDto extends MemberSaveRequestDto{
    @NotEmpty(message = "salt must not be empty")
    private String salt;


    @Builder
    public MemberEncryptedSaveRequestDto(String loginId, String loginPwd, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress, String encryptedLoginPwd, String salt) {
        super(loginId, encryptedLoginPwd, lastName, firstName, birth, email, zipcode, mainAddress, subAddress);
        this.salt = salt;
    }

    public MemberEncryptedSaveRequestDto toDto(MemberSaveRequestDto memberSaveRequestDto, String encodedPwd, String salt) {
        return MemberEncryptedSaveRequestDto.builder()
                .loginId(memberSaveRequestDto.getLoginId())
                .encryptedLoginPwd(encodedPwd)
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


