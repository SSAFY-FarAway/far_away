package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.FileInfoSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.entity.FileInfo;
import com.ssafy.faraway.domain.hotplace.repository.FileInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileInfoServiceImpl implements FileInfoService {
    private final FileInfoRepository fileInfoRepository;

    @Override
    public Integer save(List<FileInfoSaveRequestDto> list) throws Exception {
        List<FileInfo> files = new ArrayList<>();
        for (FileInfoSaveRequestDto fileSaveRequestDto : list) {
            files.add(fileSaveRequestDto.toEntity());
        }
        return fileInfoRepository.save(files);
    }
}
