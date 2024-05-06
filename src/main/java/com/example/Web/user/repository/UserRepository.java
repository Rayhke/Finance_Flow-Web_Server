package com.example.Web.user.repository;

import com.example.Web.user.UserDTO;
import com.example.Web.user.UserVO;
import com.google.gson.JsonObject;

public interface UserRepository {

    String request(JsonObject json);

    /*void socketConnect();

    void socketRead();

    void socketWrite();

    void socketClose();

    String insertUsers(UserDTO userDTO);

    String selectUsers(String user_email);

    String updateUsers(UserDTO userDTO);

    String deleteUsers(String user_id);*/
}