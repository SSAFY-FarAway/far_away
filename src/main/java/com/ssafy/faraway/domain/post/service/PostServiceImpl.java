package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.common.Pagination;
import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.req.PostUpdateRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostResponseDto;
import com.ssafy.faraway.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Transactional
    @Override
    public Integer save(PostSaveRequestDto postSaveRequestDto) throws Exception {
        return postRepository.save(postSaveRequestDto.toEntity());
    }

//    @Transactional(readOnly = true)
//    @Override
//    public List<PostListResponseDto> findAllByCondition(SearchCondition searchCondition) throws Exception {
//        return postRepository.findAllByCondition(searchCondition);
//    }

    @Transactional(readOnly = true)
    @Override
    public PagingResponse<PostListResponseDto> findAllByCondition(SearchCondition searchCondition) throws Exception {
        int count = postRepository.getTotalCount(searchCondition);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, searchCondition);
        searchCondition.setPagination(pagination);

        List<PostListResponseDto> list = postRepository.findAllByCondition(searchCondition);
        return new PagingResponse<>(list, pagination);
    }

    @Transactional(readOnly = true)
    @Override
    public PostResponseDto findById(Long id) throws Exception {
        return postRepository.findById(id);
    }

    @Transactional
    @Override
    public Integer updateHit(Long id) throws Exception {
        return postRepository.updateHit(id);
    }

    @Transactional
    @Override
    public Integer update(PostUpdateRequestDto postUpdateRequestDto) throws Exception {
        return postRepository.update(postUpdateRequestDto);
    }

    @Transactional
    @Override
    public Integer delete(Long id) throws Exception {
        return postRepository.delete(id);
    }
}
