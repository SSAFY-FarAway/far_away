package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceUpdateRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceListResponseDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceResponseDto;

public interface HotPlaceService {
    Integer save(HotPlaceSaveRequestDto hotPlaceSaveRequestDto) throws Exception;
    HotPlaceResponseDto findById(Long id) throws Exception;
    Integer updateHit(Long id) throws Exception;
    PagingResponse<HotPlaceListResponseDto> findAllByCondition(SearchCondition searchCondition) throws Exception;
    Integer update(HotPlaceUpdateRequestDto hotPlaceUpdateRequestDto) throws Exception;
    Integer delete(Long id) throws Exception;
}
