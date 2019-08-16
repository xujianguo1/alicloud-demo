package com.xu.mircoservice.productserver.service.impl;

import com.xu.mircoservice.productclient.model.Product;
import com.xu.mircoservice.productclient.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.math.BigDecimal;
import java.util.Random;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        log.info("我收到了一个消息。getProductById={} ",productId);
        Product p =createProduct(productId,null);
        p.setExtInfo("process Ip="+RpcContext.getContext().getLocalAddressString());
        log.info("getProductById 处理完成，要返回了。。" );
        return p;
    }

    public Product getProductByName(String name){
        Long pId = new Random().nextLong();
        Product p = createProduct(pId,name);
        return p;
    }

    private Product createProduct(Long productId,String name){
        Product p = new Product();
        p.setProductId(productId);
        if(name == null){
            p.setProductName("我的名字跟Id有关："+productId);
        }else{
            p.setProductName(name);
        }

        p.setCatName("玩具");
        p.setSkuId("sku-1-"+productId);
        p.setPrice(new BigDecimal(11.1));
        p.setStockNum(100L);
        return p;
    }
}
