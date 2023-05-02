package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.FileInfoSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.FileInfoListResponseDto;

import java.util.List;

public interface FileInfoService {
    Integer save(List<FileInfoSaveRequestDto> list) throws Exception;
    List<FileInfoListResponseDto> findAllFileInfoByHotPlaceId(long hotPlaceId) throws Exception;
    Integer delete(long id) throws Exception;
    Integer deleteFileInfoByHotPlaceId(long hotPlaceId) throws Exception;
}
