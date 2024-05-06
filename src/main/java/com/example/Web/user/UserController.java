package com.example.Web.user;

import com.example.Web.user.repository.UserRepositoryImpl;
import com.example.Web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        UserDTO result = userService.insert(userDTO);

        // UserRepositoryImpl tcp = new UserRepositoryImpl();
        // tcp.insertUsers(userDTO);
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

    @GetMapping("/login")
    public String loginUsers() {
        return "user/loginUsers";
    }

    @PostMapping("/login")
    public String loginUsersStart(@ModelAttribute UserDTO userDTO,
                                  HttpServletRequest request) {


        /*if (id.equals("nink1234") && pwd.equals("asd123")) {

            HttpSession session = request.getSession(true);
            session.setAttribute("userId", id);
            session.setMaxInactiveInterval(1800);
        }*/

        return "index";
    }

    @GetMapping("/logout")
    public String logoutUsers() {
        return "index";
    }
}