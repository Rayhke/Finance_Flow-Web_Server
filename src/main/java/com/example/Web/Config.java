package com.example.Web;

import com.example.Web.common.json.JsonHandlerImpl;
import com.example.Web.common.socket.SocketHandler;
import com.example.Web.common.socket.SocketHandlerImpl;
import com.example.Web.ledger.repository.LedgerRepository;
import com.example.Web.ledger.repository.LedgerRepositoryImpl;
import com.example.Web.user.repository.UserRepository;
import com.example.Web.user.repository.UserRepositoryImpl;
import com.example.Web.ledger.service.LedgerService;
import com.example.Web.ledger.service.LedgerServiceImpl;
import com.example.Web.user.service.UserService;
import com.example.Web.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final JsonHandlerImpl jsonHandler;
    private final SocketHandlerImpl socketHandler;


    @Autowired
    public Config(JsonHandlerImpl jsonHandler, SocketHandlerImpl socketHandler) {
        this.jsonHandler = jsonHandler;
        this.socketHandler = socketHandler;
    }

    /*private final EntityManager em;

    @Autowired
    public Config(EntityManager em) {
        this.em = em;
    }*/

    // ===============================================

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl(socketHandler);
    }

    // ===============================================

    @Bean
    public LedgerService ledgerService() {
        return new LedgerServiceImpl(ledgerRepository());
    }

    @Bean
    public LedgerRepository ledgerRepository() {
        return new LedgerRepositoryImpl();
    }

    // ===============================================




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
