package com.ssafy.faraway.domain.member.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class Member {
    private long id;
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
    private long mileage;
    private int role;
    private int certified;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    @Builder
    public Member(String loginId, String loginPwd, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress, String salt, int role) {
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
        this.role = role;
    }
}


