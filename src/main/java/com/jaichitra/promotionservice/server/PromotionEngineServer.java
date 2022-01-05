package com.jaichitra.promotionservice.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jaichitra.promotionservice")
public class PromotionEngineServer {

    public static void main(String[] args) {
        SpringApplication.run(PromotionEngineServer.class, args);
    }
}
