package com.ssafy.faraway.domain.hotplace.controller;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceCommentSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceUpdateRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceListResponseDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceResponseDto;
import com.ssafy.faraway.domain.hotplace.service.HotPlaceCommentService;
import com.ssafy.faraway.domain.hotplace.service.HotPlaceService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotplace")
@Api(tags = "hotplace")
public class HotPlaceController {
    private final HotPlaceService hotPlaceService;
    private final HotPlaceCommentService hotPlaceCommentService;

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

    @GetMapping("/{id}")
    public ResponseEntity<HotPlaceResponseDto> findHotPlaceById(@PathVariable Long id) {
        try {
            HotPlaceResponseDto hotPlaceResponseDto = hotPlaceService.findById(id);
            hotPlaceService.updateHit(id);
            if (hotPlaceResponseDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<HotPlaceResponseDto>(hotPlaceResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity findAllHotPlace(@ModelAttribute SearchCondition searchCondition) {
        PagingResponse<HotPlaceListResponseDto> pagingResponse = null;
        try {
            pagingResponse = hotPlaceService.findAllByCondition(searchCondition);
            if (pagingResponse == null) {
                return ResponseEntity.noContent().build();
            }
            return new ResponseEntity<PagingResponse<HotPlaceListResponseDto>>(pagingResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity updateHotPlace(@RequestBody @Valid HotPlaceUpdateRequestDto hotPlaceUpdateRequestDto) {
        try {
            int result = hotPlaceService.update(hotPlaceUpdateRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHotPlace(@PathVariable Long id) {
        try {
            int result = hotPlaceService.delete(id);
            if (result == 0) {
                return ResponseEntity.badRequest().build()
                        ;
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/comment")
    public ResponseEntity saveHotPlaceComment(@RequestBody @Valid HotPlaceCommentSaveRequestDto hotPlaceCommentSaveRequestDto) {
        try {
            int result = hotPlaceCommentService.save(hotPlaceCommentSaveRequestDto);
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