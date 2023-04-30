package com.ssafy.faraway.domain.post.service;

import com.ssafy.faraway.domain.post.dto.req.PostCommentSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostCommentListResponseDto;
import com.ssafy.faraway.domain.post.repository.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository postCommentRepository;

    @Transactional
    @Override
    public Integer save(PostCommentSaveRequestDto postCommentSaveRequestDto) throws Exception {
        return postCommentRepository.save(postCommentSaveRequestDto.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostCommentListResponseDto> findAllByPostId(long postId) throws Exception {
        return postCommentRepository.findAllByPostId(postId);
    }
}
