package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceCommentSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceCommentListResponseDto;
import com.ssafy.faraway.domain.hotplace.repository.HotPlaceCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HotPlaceCommentServiceImpl implements HotPlaceCommentService {
    private final HotPlaceCommentRepository hotPlaceCommentRepository;

    @Override
    public Integer save(HotPlaceCommentSaveRequestDto hotPlaceCommentSaveRequestDto) throws Exception {
        return hotPlaceCommentRepository.save(hotPlaceCommentSaveRequestDto.toEntity());
    }

    @Override
    public List<HotPlaceCommentListResponseDto> findAllByHotPlaceId(Long id) throws Exception {
        return hotPlaceCommentRepository.findAllByHotPlaceId(id);
    }
}