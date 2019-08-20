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

    static {
        initSentinelProperty();
    }
    private static void initSentinelProperty(){
        System.setProperty("project.name","order-demo");
        System.setProperty("csp.sentinel.dashboard.server","10.242.138.155:7070");
        System.setProperty("csp.sentinel.api.port","7083");
        System.setProperty("java.net.preferIPv4Stack","true");
    }

}
