package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.repository.HotPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HotPlaceServiceImpl implements HotPlaceService {
    private final HotPlaceRepository hotPlaceRepository;

    @Override
    public Integer save(HotPlaceSaveRequestDto hotPlaceSaveRequestDto) throws Exception {
        return hotPlaceRepository.save(hotPlaceSaveRequestDto.toEntity());
    }
}
