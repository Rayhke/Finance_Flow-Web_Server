package com.example.Web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    public String home() {
        return "index";
    }

    @GetMapping("finances/")    // 장부
    public String finance() {
        return "finances";
    }

    @GetMapping("calendars/")   // 캘린더
    public String calendar() {
        return "calendars";
    }
}