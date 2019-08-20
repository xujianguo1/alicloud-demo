package com.xu.mircoservice.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductDemoApplication.class, args);
    }

    static{
        initSentinelProperty();
    }

    private static void initSentinelProperty(){
        System.setProperty("project.name","product-demo");
        System.setProperty("csp.sentinel.dashboard.server","10.242.138.155:7070");
        System.setProperty("csp.sentinel.api.port","7082");
        System.setProperty("java.net.preferIPv4Stack","true");
    }

}
