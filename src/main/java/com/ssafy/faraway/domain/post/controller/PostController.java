package com.ssafy.faraway.domain.post.controller;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.post.dto.req.PostCommentSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.req.PostSaveRequestDto;
import com.ssafy.faraway.domain.post.dto.req.PostUpdateRequestDto;
import com.ssafy.faraway.domain.post.dto.res.PostCommentListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import com.ssafy.faraway.domain.post.dto.res.PostResponseDto;
import com.ssafy.faraway.domain.post.service.PostCommentService;
import com.ssafy.faraway.domain.post.service.PostService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Api(tags = "post")
public class PostController {
    private final PostService postService;
    private final PostCommentService postCommentService;

    @PostMapping(value = "/")
    public ResponseEntity savePost(@RequestBody @Valid final PostSaveRequestDto postSaveRequestDto) {
        try {
            int result = postService.save(postSaveRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<PagingResponse<PostListResponseDto>> findAllPost(@ModelAttribute SearchCondition searchCondition) {
        PagingResponse<PostListResponseDto> pagingResponse = null;
        try {
//            list = postService.findAllByCondition(searchCondition);
            System.out.println(searchCondition);
            pagingResponse = postService.findAllByCondition(searchCondition);
            System.out.println(pagingResponse);
            if (pagingResponse != null) {
                return new ResponseEntity<PagingResponse<PostListResponseDto>>(pagingResponse, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponseDto> findPostById(@PathVariable Long id) {
        PostResponseDto postResponseDto = null;
        try {
            postResponseDto = postService.findById(id);
            int result = postService.updateHit(id);
            if (postResponseDto == null || result == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<PostResponseDto>(postResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/")
    public ResponseEntity updatePost(@RequestBody @Valid final PostUpdateRequestDto postUpdateRequestDto) {
        try {
            int result = postService.update(postUpdateRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) {
        try {
            int result = postService.delete(id);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/comment")
    public ResponseEntity savePostComment(@RequestBody @Valid final PostCommentSaveRequestDto postCommentSaveRequestDto) {
        try {
            int result = postCommentService.save(postCommentSaveRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/{id}/comment")
    public ResponseEntity<List<PostCommentListResponseDto>> findCommentByPostId(@PathVariable Long id) {
        List<PostCommentListResponseDto> list = null;
        try {
            list = postCommentService.findAllByPostId(id);
            if (list == null || list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<PostCommentListResponseDto>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
