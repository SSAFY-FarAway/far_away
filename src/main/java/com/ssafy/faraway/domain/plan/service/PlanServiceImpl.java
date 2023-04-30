package com.ssafy.faraway.domain.plan.service;

import com.ssafy.faraway.common.PlanSearchCondition;
import com.ssafy.faraway.common.util.ShortestPath;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.plan.dto.req.PlanSaveRequestDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetDetailResponseDto;
import com.ssafy.faraway.domain.plan.dto.res.PlanGetResponseDto;
import com.ssafy.faraway.domain.plan.repository.PlanRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{
    private final PlanRepository planRepository;
    @Override
    public int save(PlanSaveRequestDto planSaveRequestDto) throws Exception {
        return planRepository.save(planSaveRequestDto);
    }

    @Override
    public List<PlanGetResponseDto> findAllByCondition(PlanSearchCondition planSearchCondition) throws Exception {
        return planRepository.findAllByCondition(planSearchCondition);
    }

    @Override
    public PlanGetDetailDto findById(Long id) throws Exception {
        return planRepository.findById(id);
    }

    @Override
    public List<Long> getShortestPath(List<AttractionGetResponseDto> attractionList) {
        List<Long> list = new ArrayList<>();
        //  attractionList 로 map 을 만들기
        double map[][] = makeMap(attractionList);
        // map으로 최단 경로 구하기
        ShortestPath sp = new ShortestPath(map);
        sp.findShortestPath();
        int[] result = sp.getResult();
        // 최단 경로 해당 attractinoList의 contentId 리스트 반환하기
        for(int i =0;i<result.length;i++) {
            list.add(attractionList.get(result[i]).getContentId());
        }
        return list;
    }

    private double[][] makeMap(List<AttractionGetResponseDto> attractionList) {
        int size = attractionList.size();
        double[][] map = new double[size][size];
        for(int i =0;i<size;i++) {
            double x = attractionList.get(i).getLatitude();
            double y = attractionList.get(i).getLongitude();
            for(int j =0;j<size;j++) {
                if(i==j) continue;
                double nx = attractionList.get(j).getLatitude();
                double ny = attractionList.get(j).getLongitude();
                map[i][j] = Math.sqrt(Math.abs(x - nx) * Math.abs(x - nx) + Math.abs(y - ny) * Math.abs(y - ny));

            }
        }
        return map;
    }

}
