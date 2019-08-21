package com.xu.mircoservice.orderdemo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderDemoApplication.class, args);
    }

}
