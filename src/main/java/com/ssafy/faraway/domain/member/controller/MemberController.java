package com.ssafy.faraway.domain.member.controller;

import com.ssafy.faraway.domain.member.dto.req.MemberLoginPwdUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberLoginRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberSaveRequestDto;
import com.ssafy.faraway.domain.member.dto.req.MemberUpdateRequestDto;
import com.ssafy.faraway.domain.member.dto.res.MemberListResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberLoginResponseDto;
import com.ssafy.faraway.domain.member.dto.res.MemberResponseDto;
import com.ssafy.faraway.domain.member.service.MemberService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Api(tags = "member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            // session 을 가지고와
            // session 가지고 있는 id랑 id 같은지 비교 -> 같으면 return 정상적으로 / 같지 않으면 비정상적인 접근

            MemberResponseDto memberResponseDto = memberService.findById(id);
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
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> save(@RequestBody @Valid final MemberSaveRequestDto memberSaveRequestDto) {
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
    public ResponseEntity<?> update(@RequestBody @Valid MemberUpdateRequestDto memberUpdateRequestDto) {
        try {
            memberService.update(memberUpdateRequestDto);
            List<MemberListResponseDto> list = memberService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @PutMapping("/new-password")
    public ResponseEntity<?> loginPwdUpdate(@RequestBody @Valid MemberLoginPwdUpdateRequestDto memberLoginPwdUpdateRequestDto) {
        try {
            if(memberService.loginPwdUpdate(memberLoginPwdUpdateRequestDto) == null){
                return new ResponseEntity<>("비밀번호가 올바르지 않습니다.", HttpStatus.UNAUTHORIZED);
            }
            MemberResponseDto memberResponseDto = memberService.findById(memberLoginPwdUpdateRequestDto.getId());
            return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(@RequestParam Long id, @RequestParam String loginPwd) {
        try {
            if(memberService.delete(id, loginPwd) == null){
                return new ResponseEntity<>("비밀번호가 올바르지 않습니다.", HttpStatus.UNAUTHORIZED);
            }
            List<MemberListResponseDto> list = memberService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> findByLoginIdAndLoginPwd(@RequestBody @Valid MemberLoginRequestDto memberLoginRequestDto, HttpSession session) {
        try {
            MemberLoginResponseDto memberLoginResponseDto = memberService.findByLoginIdAndLoginPwd(memberLoginRequestDto);
            if(memberLoginResponseDto != null){
                session.setAttribute("loginMember", memberLoginResponseDto);
                return new ResponseEntity<>(memberLoginResponseDto, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        try {
            MemberLoginResponseDto memberLoginResponseDto = (MemberLoginResponseDto) session.getAttribute("loginMember");
            if(memberLoginResponseDto == null){
                return new ResponseEntity<>("로그인 정보가 없습니다.", HttpStatus.BAD_REQUEST);
            }
            session.invalidate();
            return new ResponseEntity<>("로그아웃 성공.", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @GetMapping("/check/{loginId}") //countByLoginId
    public ResponseEntity<?> loginIdCheck(@PathVariable("loginId") String loginId) {
        try {
            int cnt = memberService.loginIdCheck(loginId);
            return new ResponseEntity<>(cnt + "", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @PostMapping("/check")
    public ResponseEntity<?> loginPwdCheck(@RequestParam Long id, @RequestParam String loginPwd) {
        try {
            if(!memberService.loginPwdCheck(id, loginPwd)){ // different
                return new ResponseEntity<>("비밀번호가 올바르지 않습니다.", HttpStatus.UNAUTHORIZED);
            }
            List<MemberListResponseDto> list = memberService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @GetMapping("/login-id")
    public ResponseEntity<?> findLoginIdByEmailAndBirth(@RequestParam @NotEmpty(message = "loginId ust not be empty") @Email String email,
                                                        @RequestParam @NotEmpty @Size(min=6, max=6, message = "birth's size must not be 6") String birth){
        try{
            Map<String, String> map = new HashMap<>();
            map.put("email", email);
            map.put("birth", birth);
            String loginId = memberService.findLoginIdByEmailAndBirth(map);
            if(loginId == null){
                return new ResponseEntity<>("이메일과 생년월일을 정확히 입력해 주세요.", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(loginId, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    @GetMapping("/login-pwd")
    public ResponseEntity<?> findLoginPwd(@RequestParam @Size(min = 6, max = 20, message = "loginId ust not be empty") String loginId,
                                            @RequestParam @NotEmpty(message = "loginId ust not be empty") @Email String email,
                                            @RequestParam @NotEmpty @Size(min=6, max=6, message = "birth's size must not be 6") String birth){
        try{
            Map<String, String> map = new HashMap<>();
            map.put("loginId", loginId);
            map.put("email", email);
            map.put("birth", birth);
            String loginPwd = memberService.findLoginPwd(map);
            if(loginPwd == null){
                return new ResponseEntity<>("이메일, 생년월일, 아이디를 정확히 입력해 주세요", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(loginPwd, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
