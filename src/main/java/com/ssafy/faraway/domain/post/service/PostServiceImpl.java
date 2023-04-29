package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.common.PostSearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostResponseDto;
import com.ssafy.faraway.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Transactional
    @Override
    public Integer save(PostSaveRequestDto postSaveRequestDto) throws Exception {
        System.out.println(postSaveRequestDto);
        return postRepository.save(postSaveRequestDto.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostListResponseDto> findAllByCondition(PostSearchCondition postSearchCondition) throws Exception {
        return postRepository.findAllByCondition(postSearchCondition);
    }

    @Transactional(readOnly = true)
    @Override
    public PostResponseDto findById(Long id) throws Exception {
        return postRepository.findById(id);
    }
}
