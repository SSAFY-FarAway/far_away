package com.ssafy.faraway.domain.member.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginResponseDto {
    private long id;
    private String loginId;
    private String lastName;
    private String firstName;
    private long mileage;
    private int role;


}
