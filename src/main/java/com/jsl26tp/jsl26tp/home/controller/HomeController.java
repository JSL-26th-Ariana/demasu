package com.jsl26tp.jsl26tp.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 메인 페이지 (지도)
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
