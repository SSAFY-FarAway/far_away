package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceListResponseDto;

public interface HotPlaceService {
    Integer save(HotPlaceSaveRequestDto hotPlaceSaveRequestDto) throws Exception;
    PagingResponse<HotPlaceListResponseDto> findAllByCondition(SearchCondition searchCondition) throws Exception;
}
