package com.example.Web.repository;

import com.example.Web.controller.dto.UserDTO;

public interface DataBaseRepository {

    void socketConnect();

    void socketClose();

    String send(UserDTO userDTO);
}
