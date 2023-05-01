package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceCommentSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceCommentListResponseDto;

import java.util.List;

public interface HotPlaceCommentService {
    Integer save(HotPlaceCommentSaveRequestDto hotPlaceCommentSaveRequestDto) throws Exception;
    List<HotPlaceCommentListResponseDto> findAllByHotPlaceId(Long id) throws Exception;
}