package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.common.PostSearchCondition;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PostListResponseDto> findAllByCondition(PostSearchCondition postSearchCondition) throws Exception {
        return postRepository.findAllByCondition(postSearchCondition);
    }
}
