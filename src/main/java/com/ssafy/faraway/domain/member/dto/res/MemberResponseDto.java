package com.ssafy.faraway.domain.member.dto.res;

import com.ssafy.faraway.domain.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberResponseDto {
    private long id;
    private String loginId;
    private String lastName;
    private String firstName;
    private String birth;
    private String email;
    private String zipcode;
    private String mainAddress;
    private String subAddress;
    private long mileage;
    private int certified;
    private int role;
    private LocalDateTime createdDate;
}
