package com.ssafy.faraway;

import io.swagger.annotations.Api;
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

    @GetMapping("/search_place")
    public String searchPlace() {
        return "attraction/search_place";
    }

    @GetMapping("/plan_list")
    public String planList(@RequestParam int page, Model model) {
        model.addAttribute("page",page);

        return "plan/list";

    }
}
