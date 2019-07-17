package com.xu.mircoservice.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductDemoApplication.class, args);
    }

}
