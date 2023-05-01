package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.FileInfoSaveRequestDto;

import java.util.List;

public interface FileInfoService {
    Integer save(List<FileInfoSaveRequestDto> list) throws Exception;
}
