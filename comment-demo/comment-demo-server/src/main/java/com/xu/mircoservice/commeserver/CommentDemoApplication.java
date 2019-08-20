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

    static {
        initSentinelProperty();
    }
    private static void initSentinelProperty(){
        System.setProperty("project.name","comment-demo");
        System.setProperty("csp.sentinel.dashboard.server","10.242.138.155:7070");
        System.setProperty("csp.sentinel.api.port","7084");
        System.setProperty("java.net.preferIPv4Stack","true");
    }
}
