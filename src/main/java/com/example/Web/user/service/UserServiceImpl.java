package com.example.Web.user.service;

import com.example.Web.common.json.JsonHandlerImpl;
import com.example.Web.user.UserDTO;
import com.example.Web.user.repository.UserRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends JsonHandlerImpl<UserDTO> implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO insert(UserDTO userDTO) {
        String result = userRepository.request(ObjectToJson("save", userDTO));
        return parseToObject(result);
    }

    @Override
    protected UserDTO parseToObject(String result) {
        JsonObject json = gson.fromJson(result, JsonObject.class);
        return new UserDTO(json.getAsJsonObject("user"));
    }

    @Override
    protected String getEntityType() {
        return "user";
    }
}
