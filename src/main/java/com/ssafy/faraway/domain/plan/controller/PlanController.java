package com.ssafy.faraway.domain.plan.controller;

import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.domain.attraction.dto.req.AttractionGetRequestDto;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.service.AttractionService;
import com.ssafy.faraway.domain.member.entity.Member;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailResponseDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;
import com.ssafy.faraway.domain.plan.service.PlanService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;
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
    private final AttractionService attractionService;

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

    // 1. id로 요청
    // 2. id로 해당 plan 정보 요청하여 가져오기 => PlanDetailDto
    // 3. plan리스트로 attractionList가져오기 (AttractionService)
    // 4. attractionList를 가지고 최단 경로 리스트 가져오기
    // 5. PlanDetailResponseDto 로 build한 후 응답
    @GetMapping("/{id}")
    public ResponseEntity<PlanGetDetailResponseDto> findPlanById(@PathVariable Long id) {
        PlanGetDetailDto plan = null;
        try {

            plan = planService.findById(id);
            if(plan == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            planService.updateHit(id);

            //해당 값이 있는 경우 plan list 로 attractionList 받아오기
            List<AttractionGetResponseDto> attractionList = attractionService.findAllByIds(plan.getPlan());

            // 해당 attractionList로 최단 경로 list 받아오기
            List<Long> shortestPath = planService.getShortestPath(attractionList);

            // PlanDetailResponseDto 로 build
            PlanGetDetailResponseDto planGetDetailResponseDto = new PlanGetDetailResponseDto().toDto(plan,attractionList,shortestPath);
            return new ResponseEntity<>(planGetDetailResponseDto,HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
