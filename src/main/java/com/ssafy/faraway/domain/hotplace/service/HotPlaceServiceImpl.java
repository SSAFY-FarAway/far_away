package com.ssafy.faraway.domain.hotplace.service;

import com.ssafy.faraway.common.Pagination;
import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.hotplace.dto.req.HotPlaceSaveRequestDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceListResponseDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceResponseDto;
import com.ssafy.faraway.domain.hotplace.repository.HotPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HotPlaceServiceImpl implements HotPlaceService {
    private final HotPlaceRepository hotPlaceRepository;

    @Transactional
    @Override
    public Integer save(HotPlaceSaveRequestDto hotPlaceSaveRequestDto) throws Exception {
        return hotPlaceRepository.save(hotPlaceSaveRequestDto.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public HotPlaceResponseDto findById(Long id) throws Exception {
        return hotPlaceRepository.findById(id);
    }

    @Transactional
    @Override
    public Integer updateHit(Long id) throws Exception {
        return hotPlaceRepository.updateHit(id);
    }

    @Transactional(readOnly = true)
    @Override
    public PagingResponse<HotPlaceListResponseDto> findAllByCondition(SearchCondition searchCondition) throws Exception {
        int count = hotPlaceRepository.getTotalCount(searchCondition);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, searchCondition);
        searchCondition.setPagination(pagination);

        List<HotPlaceListResponseDto> list = hotPlaceRepository.findAllByCondition(searchCondition);
        return new PagingResponse<>(list, pagination);
    }
}
