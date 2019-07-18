package com.xu.mircoservice.detailserver.controller;

import com.xu.mircoservice.detailclient.model.ProductDetailVo;
import com.xu.mircoservice.detailclient.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/detail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @RequestMapping(value="/getProductDetail",method = RequestMethod.GET)
    public ProductDetailVo getProductDetail( Long productId){
        ProductDetailVo detailVo=this.productDetailService.getProductDetailById(productId);
        return detailVo;
    }

    @RequestMapping("/getProductOrderNum/{productId}")
    public Map getProductOrderNum(@PathVariable("productId") Long productId){
        Map<String,Object> result = new HashMap<>();
        Long orderNum = this.productDetailService.getProductOrderNumById(productId);
        result.put("orderNum",orderNum);
        return result;
    }
}
