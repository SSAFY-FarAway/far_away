package com.ssafy.faraway.domain.member.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberListResponseDto {
    private long id;
    private String loginId;
    private String lastName;
    private String firstName;
    private String birth;
    private String email;
    private long mileage;
    private int role;
    private int certified;
}

