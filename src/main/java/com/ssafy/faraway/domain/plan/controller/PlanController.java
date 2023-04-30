package com.ssafy.faraway.domain.plan.controller;

import com.ssafy.faraway.domain.member.entity.Member;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.service.PlanService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/plan")
@Api(tags="plan")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping("/")
    public ResponseEntity savePlan(@RequestBody PlanSaveRequestDto planSaveRequestDto, HttpSession session) {
        // TODO: session의 loginId를 기반으로 memberId 를 받아오는 로직 필요
        Long memberId = 1L;
        planSaveRequestDto.setMemberId(memberId);
        try {
            int result = planService.save(planSaveRequestDto);
            if(result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }


    }
}
