package com.ssafy.faraway.domain.plan.controller;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.attraction.dto.req.AttractionGetRequestDto;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.service.AttractionService;
import com.ssafy.faraway.domain.member.entity.Member;
import com.ssafy.faraway.domain.plan.dto.req.PlanCommentSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanCommentUpdateRequestDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanUpdateRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanCommentListResponseDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailResponseDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;
import com.ssafy.faraway.domain.plan.service.PlanCommentService;
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
    private final PlanCommentService planCommentService;

    @PostMapping("")
    public ResponseEntity<Integer> savePlan(@RequestBody PlanSaveRequestDto planSaveRequestDto, HttpSession session) {
        // TODO: session의 loginId를 기반으로 memberId 를 받아오는 로직 필요
        planSaveRequestDto.setMemberId(planSaveRequestDto.getMemberId());
        try {
            int result = planService.save(planSaveRequestDto);
            if(result == 0) {
                return ResponseEntity.badRequest().build();
            }
            System.out.println(planSaveRequestDto.getId());
            return new ResponseEntity(planSaveRequestDto.getId(),HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping()
    public ResponseEntity<PagingResponse<PlanGetResponseDto>> findAllByCondition(@ModelAttribute SearchCondition searchCondition) {
        PagingResponse<PlanGetResponseDto> pagingResponse = null;
        try {
            pagingResponse = planService.findAllByCondition(searchCondition);
            System.out.println(pagingResponse);
            if(pagingResponse == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pagingResponse,HttpStatus.OK);
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
            int[] shortestPath = planService.getShortestPath(attractionList);

            // PlanDetailResponseDto 로 build
            PlanGetDetailResponseDto planGetDetailResponseDto = new PlanGetDetailResponseDto().toDto(plan,attractionList,shortestPath);
            return new ResponseEntity<>(planGetDetailResponseDto,HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("")
    public ResponseEntity updatePlan(@RequestBody PlanUpdateRequestDto planUpdateRequestDto) {

        try {
            // TODO: session id 와 plan Member_id 검사
            int result = planService.updatePlan(planUpdateRequestDto);
            if(result != 0) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }


    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletePlan(@PathVariable Long id) {
        try {
            // TODO: 세션 ID와 해당 경로의 MEMBER_ID 일치하는지 확인
            int result = planService.deletePlan(id);
            if(result != 0) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/comment")
    public ResponseEntity savePlanComment(@RequestBody PlanCommentSaveRequestDto planCommentSaveRequestDto) {
        //TODO: 세션 ID와 해당 댓글의 MEMBER_ID 일치하는지 확인
        try {
            int result = planCommentService.save(planCommentSaveRequestDto);
            if(result != 0) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity deletePlanComment(@PathVariable Long id) {
        try {
            int result = planCommentService.delete(id);
            if(result != 0) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}/comment")
    public ResponseEntity<List<PlanCommentListResponseDto>> findCommentByPlanId(@PathVariable Long id) {
        List<PlanCommentListResponseDto> list = null;
        try {
            list = planCommentService.findCommentByPlanId(id);
            if(list != null) {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/comment")
    public ResponseEntity updateComment(@RequestBody PlanCommentUpdateRequestDto planCommentUpdateRequestDto) {
        // TODO: 세션 ID와 comment 의 member_id 비교 로직 필요
        try {
            int result =  planCommentService.update(planCommentUpdateRequestDto);
            if(result != 0) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


}
