package com.example.Web.repository;

import com.example.Web.controller.dto.UserDTO;

public interface UserRepository {

    void socketConnect();

    void socketRead();

    void socketWrite();

    void socketClose();

    String insertUsers(UserDTO userDTO);

    String selectUsers(String user_email);

    String updateUsers(UserDTO userDTO);

    String deleteUsers(String user_id);
}