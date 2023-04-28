package com.ssafy.faraway.domain.member.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
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
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}


