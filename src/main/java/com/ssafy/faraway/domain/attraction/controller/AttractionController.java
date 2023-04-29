package com.ssafy.faraway.domain.attraction.controller;

import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.service.AttractionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor
@Api(tags="attraction")
public class AttractionController {

    private final AttractionService attractionService;

    @RequestMapping("/")
    public ResponseEntity<List<AttractionGetResponseDto>> findAllAttraction() {
        System.out.println("나 불리니?");
        List<AttractionGetResponseDto> list = null;
        list = attractionService.findAll();
        if(list == null || list.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
