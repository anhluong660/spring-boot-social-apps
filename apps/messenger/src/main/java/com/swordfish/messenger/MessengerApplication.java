package com.swordfish.messenger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableFeignClients
@EnableWebSocket
@SpringBootApplication
public class MessengerApplication {

    private static final Logger log = LoggerFactory.getLogger(MessengerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MessengerApplication.class, args);

        log.info("+++++++++++++++++++++++++++++++++++++++++");
        log.info("[[ Start Messenger Application Success ]]");
        log.info("+++++++++++++++++++++++++++++++++++++++++");
    }
}
