package com.example.Web.controller;

import com.example.Web.controller.dto.UserDTO;
import com.example.Web.repository.UserTcpRepository;
import com.example.Web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/insert")
    public String insertUsers() {
        return "user/insertUsers";
    }

    @PostMapping("/insert")
    public String insertUsersStart(@ModelAttribute UserDTO userDTO) {
        UserTcpRepository tcp = new UserTcpRepository();
        tcp.insertUsers(userDTO);
        return "index"; // 임시
    }

    @GetMapping("/select")
    public String selectUsers() {
        return "user/selectUsers";
    }

    @PostMapping("/select")
    public String selectUsersStart() {
        return "index"; // 임시
    }

    @GetMapping("/update")
    public String updateUsers() {
        return "user/updateUsers";
    }

    @PostMapping("/update")
    public String updateUsersStart() {
        return "index"; // 임시
    }

    @GetMapping("/delete")
    public String deleteUsers() {
        return "user/deleteUsers";
    }

    @PostMapping("/delete")
    public String deleteUsersStart() {
        return "index"; // 임시
    }
}