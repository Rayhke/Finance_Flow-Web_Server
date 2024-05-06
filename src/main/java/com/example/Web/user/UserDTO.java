package com.example.Web.user;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;

    private String pwd;

    private String email;

    public UserDTO(JsonObject json) {
        this.id = json.get("id").getAsString();
        this.pwd = json.get("pwd").getAsString();
        this.email = json.get("email").getAsString();
    }
}
