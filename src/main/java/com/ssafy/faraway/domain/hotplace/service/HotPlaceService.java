package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceSaveRequestDto;

public interface HotPlaceService {
    Integer save(HotPlaceSaveRequestDto hotPlaceSaveRequestDto) throws Exception;
}
