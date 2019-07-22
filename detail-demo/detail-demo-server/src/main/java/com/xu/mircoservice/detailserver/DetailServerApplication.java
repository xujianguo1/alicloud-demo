package com.xu.mircoservice.detailserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
public class DetailServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx= SpringApplication.run(DetailServerApplication.class, args);
        //ctx.getBean("productDetailService")
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
