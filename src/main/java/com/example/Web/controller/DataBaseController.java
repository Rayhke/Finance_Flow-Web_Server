package com.example.Web.controller;


import com.example.Web.controller.dto.UserDTO;
import com.example.Web.repository.DataBaseTcpRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DataBaseController {

    @PostMapping("finances/")
    public String save(@ModelAttribute UserDTO userDTO) {
        DataBaseTcpRepository tcp = new DataBaseTcpRepository();
        tcp.send(userDTO);
        return "index";
    }
}
