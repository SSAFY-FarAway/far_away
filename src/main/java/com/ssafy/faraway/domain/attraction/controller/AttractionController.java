package com.ssafy.faraway.domain.attraction.controller;

import com.ssafy.faraway.domain.attraction.dto.req.AttractionGetRequestDto;
import com.ssafy.faraway.domain.attraction.dto.res.AttractionGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.GugunGetResponseDto;
import com.ssafy.faraway.domain.attraction.dto.res.SidoGetResponseDto;
import com.ssafy.faraway.domain.attraction.service.AttractionService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor
@Api(tags="attraction")
public class AttractionController {

    private final AttractionService attractionService;

//    @GetMapping(value = "/")
//    public ResponseEntity<List<AttractionGetResponseDto>> findAllAttraction() {
//        List<AttractionGetResponseDto> list = null;
//        try {
//            list = attractionService.findAll();
//            if(list == null || list.size() == 0) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//
//    }

    @GetMapping("/sido")
    public ResponseEntity<List<SidoGetResponseDto>> findAllSido() {
        List<SidoGetResponseDto> list = null;
        try {
            list = attractionService.findAllSido();
            if(list == null || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/gugun/{sidoCode}}")
    public ResponseEntity<List<GugunGetResponseDto>> findAllGugun(@PathVariable int sidoCode) {
        List<GugunGetResponseDto> list = null;
        try {
            list = attractionService.findAllGugun(sidoCode);
            if(list == null || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/")
    public ResponseEntity<List<AttractionGetResponseDto>> findAttractionBySidoCodeAndGugunCodeAndContentTypeId(
            @RequestParam(name = "sido_code", required = false) int sidoCode,
            @RequestParam(name = "gugun_code", required = false) int gugunCode,
            @RequestParam(name = "content_type_id", required = false) int contentTypeId
                                                                                                               ) {
        AttractionGetRequestDto attractionGetRequestDto = new AttractionGetRequestDto().builder()
                .sidoCode(sidoCode)
                .gugunCode(gugunCode)
                .contentTypeId(contentTypeId)
                .build();
        List<AttractionGetResponseDto> list = null;
        try {
            list = attractionService.findAttractionBySidoCodeAndGugunCodeAndContentTypeId(attractionGetRequestDto);
            if(list == null || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
