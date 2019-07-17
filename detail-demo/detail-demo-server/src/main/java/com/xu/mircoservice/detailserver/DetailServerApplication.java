package com.xu.mircoservice.detailserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DetailServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetailServerApplication.class, args);
    }

}
