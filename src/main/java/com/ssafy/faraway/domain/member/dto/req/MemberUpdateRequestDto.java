package com.ssafy.faraway.domain.member.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private Long id;
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

    @Builder
    public MemberUpdateRequestDto(Long id, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.email = email;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
    }
}
