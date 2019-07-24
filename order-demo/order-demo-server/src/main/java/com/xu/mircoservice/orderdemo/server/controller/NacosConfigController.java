package com.xu.mircoservice.orderdemo.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Controller
@RequestMapping("/nacosConfig")
public class NacosConfigController {

    @Value("${Url.homepage}")
    private String homePage;

    @Value("${user.age}")
    private String userAge;

    @Value("${order.env}")
    private String orderEnv;

    @Value("${constants.welcome-word}")
    private String welcomeWord;

    @Value("${common-config.test}")
    private String commonTest;

    @RequestMapping("/getConfig")
    @ResponseBody
    public Map<String,Object> getConfig(){
        Map<String,Object> result = new HashMap<>();
        result.put("homePage",homePage);
        result.put("userAge",userAge);
        result.put("orderEnv",orderEnv);
        result.put("welcomeWord",welcomeWord);
        result.put("commonTest",commonTest);
        return  result;
    }
}
