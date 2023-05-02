package com.ssafy.faraway;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String mvModify() {
        return "member/modify";
    }

    @GetMapping("/search_place")
    public String searchPlace() {
        return "attraction/search_place";
    }

    @GetMapping("/plan_list")
    public String planList(@RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false) String key,
                           @RequestParam(required = false) String word,
                           Model model) {
        model.addAttribute("page",page);
        model.addAttribute("key",key);
        model.addAttribute("word",word);

        return "plan/list";
    }

    @GetMapping("/plan_write")
    public String planWrite() {
        return "plan/write";
    }

    @GetMapping("/plan-view")
    public String planView(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "plan/view";

    }

}
