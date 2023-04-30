package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.domain.post.dto.req.PostCommentSaveRequestDto;
import com.ssafy.faraway.domain.post.repository.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository postCommentRepository;

    @Transactional
    @Override
    public Integer save(PostCommentSaveRequestDto postCommentSaveRequestDto) throws Exception {
        return postCommentRepository.save(postCommentSaveRequestDto.toEntity());
    }
}
