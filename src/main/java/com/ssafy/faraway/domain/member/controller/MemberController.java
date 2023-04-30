package com.ssafy.faraway.domain.member.controller;

import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import com.ssafy.faraway.domain.member.service.MemberService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Api(tags = "member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable("id") Long id) {
        try {
            MemberResponseDto memberResponseDto = memberService.find(id);
            if (memberResponseDto != null)
                return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<MemberListResponseDto>> findAll() {
        List<MemberListResponseDto> list = null;
        try {
            list = memberService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (list != null && !list.isEmpty()) {
            return new ResponseEntity<List<MemberListResponseDto>>(list, HttpStatus.OK);
        }
        return new ResponseEntity<List<MemberListResponseDto>>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        try {
            memberService.save(memberSaveRequestDto);
            List<MemberListResponseDto> list = memberService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        try {
            memberService.update(memberUpdateRequestDto);
            List<MemberListResponseDto> list = memberService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(@RequestBody Long id) {
        try {
            memberService.delete(id);
            List<MemberListResponseDto> list = memberService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }



    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
