package com.ssafy.faraway.domain.plan.controller;

import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.domain.member.entity.Member;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;
import com.ssafy.faraway.domain.plan.service.PlanService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @GetMapping("/")
    public ResponseEntity<List<PlanGetResponseDto>> findAllByCondition(PlanSearchCondition planSearchCondition) {
        List<PlanGetResponseDto> list = null;
        System.out.println(planSearchCondition);
        try {
            list = planService.findAllByCondition(planSearchCondition);
            if(list == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
