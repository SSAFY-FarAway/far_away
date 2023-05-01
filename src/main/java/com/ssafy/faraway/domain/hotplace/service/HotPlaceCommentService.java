package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceCommentSaveRequestDto;

public interface HotPlaceCommentService {
    Integer save(HotPlaceCommentSaveRequestDto hotPlaceCommentSaveRequestDto) throws Exception;
}
