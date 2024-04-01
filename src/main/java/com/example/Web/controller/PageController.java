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

    @GetMapping("forum/")
    public String test() {
        return "test";
    }
}