package com.example.Web;

import com.example.Web.repository.UserRepository;
import com.example.Web.repository.UserTcpRepository;
import com.example.Web.service.UserService;
import com.example.Web.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserTcpRepository();
    }
}
