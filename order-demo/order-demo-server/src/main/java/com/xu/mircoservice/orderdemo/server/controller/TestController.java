package com.xu.mircoservice.orderdemo.server.controller;

import com.xu.mircoservice.productclient.model.Product;
import com.xu.mircoservice.productclient.service.ProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RefreshScope
@Controller
@RequestMapping("/test")
public class TestController {

    @Reference
    private ProductService productService;

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

    @RequestMapping("/getNacosConfig")
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

    @RequestMapping("/testProductById/{id}")
    @ResponseBody
    public Product testProductById(@PathVariable("id")Long id ){
        Product product = productService.getProductById(id);
        return product;
    }

    @RequestMapping("/testProductByName/{name}")
    @ResponseBody
    public Product testProductByName(@PathVariable("name")String name ){
        Product product = productService.getProductByName(name);
        return product;
    }
}
