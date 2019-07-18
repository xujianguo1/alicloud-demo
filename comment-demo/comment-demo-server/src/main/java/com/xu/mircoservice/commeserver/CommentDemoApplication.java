package com.xu.mircoservice.commeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CommentDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentDemoApplication.class, args);
    }

}
