package com.ssafy.faraway.domain.plan.dto.res;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class PlanGetDetailDto {
    private Long id;
    private String title;
    private String content;
    private Long hit;
    private String loginId;
    private List<Long> plan = new ArrayList<>(); // 여행지 리스트

    @Builder
    public PlanGetDetailDto(Long id, String title, String content, Long hit, String loginId, String plan) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.loginId = loginId;

        String[] plans = plan.split(",");
        for(String p : plans) {
            this.plan.add(Long.parseLong(p.trim()));
        }
        System.out.println(this.plan);
    }

//    public void setPlan(String plan) {
//        System.out.println(plan);
//        String[] plans = plan.split(",");
//        for(String p : plans) {
//            this.plan.add(Long.parseLong(p.trim()));
//        }
//        System.out.println(this.plan);
//    }
}
