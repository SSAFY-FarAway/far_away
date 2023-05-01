package com.ssafy.faraway.domain.hotplace.controller;

import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.service.HotPlaceService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotplace")
@Api(tags = "hotplace")
public class HotPlaceController {
    private final HotPlaceService hotPlaceService;

    @PostMapping("/")
    public ResponseEntity saveHotPlace(@RequestBody @Valid HotPlaceSaveRequestDto hotPlaceSaveRequestDto) {
        try {
            int result = hotPlaceService.save(hotPlaceSaveRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}