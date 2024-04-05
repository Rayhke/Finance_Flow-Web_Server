package com.example.Web.controller;

import com.example.Web.controller.dto.MemberDTO;
import com.example.Web.repository.DataBaseTcpRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("finances/")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        DataBaseTcpRepository tcp = new DataBaseTcpRepository();
        tcp.send(memberDTO);
        return "index";
    }
}