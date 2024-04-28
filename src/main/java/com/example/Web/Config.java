package com.example.Web;

import com.example.Web.repository.UserRepository;
import com.example.Web.repository.UserTcpRepository;
import com.example.Web.service.UserService;
import com.example.Web.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class Config {

    private final EntityManager em;

    @Autowired
    public Config(EntityManager em) {
        this.em = em;
    }

    // ===============================================

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserTcpRepository();
    }

    // ===============================================

    /*@Bean
    public TestService testService() {
        return new TestService(testRepository());
    }
    
    @Bean
    public TestRepository testRepository() {
        return new TestJpaRepository(em);
    }*/
}
