package com.xu.mircoservice.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductDemoApplication {

    static{
        initSentinelProperty();
    }
    private static void initSentinelProperty(){
        System.setProperty("java.net.preferIPv4Stack","true");
        System.setProperty("csp.sentinel.log.use.pid","true");
        System.setProperty("project.name","product-demo");
        System.setProperty("csp.sentinel.api.port","7082");
        System.setProperty("csp.sentinel.dashboard.server","192.168.55.1:7070");
    }
    public static void main(String[] args) {
        SpringApplication.run(ProductDemoApplication.class, args);
    }

}
