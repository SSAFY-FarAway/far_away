package com.ssafy.faraway.domain.post.controller;

import com.ssafy.faraway.common.PostSearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.service.PostService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Api(tags = "post")
public class PostController {
    private final PostService postService;

    @PostMapping(value = "/")
    public ResponseEntity<Integer> savePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        try {
            int result = postService.save(postSaveRequestDto);
            if (result == 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<PostListResponseDto>> findAllPost(PostSearchCondition postSearchCondition) {
        List<PostListResponseDto> list = null;
        try {
            list = postService.findAllByCondition(postSearchCondition);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (list != null && !list.isEmpty()) {
            return new ResponseEntity<List<PostListResponseDto>>(list, HttpStatus.OK);
        }
        return new ResponseEntity<List<PostListResponseDto>>(HttpStatus.NO_CONTENT);
    }
}
