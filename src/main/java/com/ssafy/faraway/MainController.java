package com.ssafy.faraway;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String mvLogin () {
        return "member/login";
    }

    @GetMapping("/logout")
    public String mvLogout () { return "index";
    }

    @GetMapping("/signUp")
    public String mvSignUp () {
        return "member/sign_up";
    }

    @GetMapping("/myPage")
    public String mvMyPage () {
        return "member/my_page";
    }

    @GetMapping("/modify")
    public String mvModify () {
        return "member/modify";
    }
}
