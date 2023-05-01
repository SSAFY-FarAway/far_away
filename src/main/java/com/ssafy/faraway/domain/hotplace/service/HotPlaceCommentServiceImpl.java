package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceCommentSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceCommentUpdateRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceCommentListResponseDto;
import com.ssafy.faraway.domain.hotplace.repository.HotPlaceCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HotPlaceCommentServiceImpl implements HotPlaceCommentService {
    private final HotPlaceCommentRepository hotPlaceCommentRepository;

    @Transactional
    @Override
    public Integer save(HotPlaceCommentSaveRequestDto hotPlaceCommentSaveRequestDto) throws Exception {
        return hotPlaceCommentRepository.save(hotPlaceCommentSaveRequestDto.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public List<HotPlaceCommentListResponseDto> findAllByHotPlaceId(Long id) throws Exception {
        return hotPlaceCommentRepository.findAllByHotPlaceId(id);
    }

    @Transactional
    @Override
    public Integer update(HotPlaceCommentUpdateRequestDto hotPlaceCommentUpdateRequestDto) throws Exception {
        return hotPlaceCommentRepository.update(hotPlaceCommentUpdateRequestDto);
    }

    @Transactional
    @Override
    public Integer delete(Long id) throws Exception {
        return hotPlaceCommentRepository.delete(id);
    }
}
