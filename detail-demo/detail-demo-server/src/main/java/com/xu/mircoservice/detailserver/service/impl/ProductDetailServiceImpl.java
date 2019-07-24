package com.xu.mircoservice.detailserver.service.impl;

import com.xu.mircoservice.commeclient.model.CommentVo;
import com.xu.mircoservice.commeclient.service.CommentService;
import com.xu.mircoservice.detailclient.model.DetailCommentVo;
import com.xu.mircoservice.detailclient.model.ProductDetailVo;
import com.xu.mircoservice.detailclient.service.ProductDetailService;
import com.xu.mircoservice.orderdemo.client.model.OrderItemVo;
import com.xu.mircoservice.orderdemo.client.service.OrderService;
import com.xu.mircoservice.productclient.model.Product;
import com.xu.mircoservice.productclient.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
@Slf4j
//spring 与dubbo的service 同时存在， BeanFacotry注册时覆盖一个spring 的service，不写Spring Service注解同项目其他地方调用，IDE会报错，实际会获取到。
//其他地方写Reference引用，又会走RPC ，消耗性能
@org.apache.dubbo.config.annotation.Service
@org.springframework.stereotype.Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Reference
    private ProductService productService;
    @Reference
    private CommentService commentService;

    @Reference
    private OrderService orderService;

    @Override
    public ProductDetailVo getProductDetailById(Long productId) {
        Product product = productService.getProductById(productId);
        if(product ==null){
            log.warn("无法查询到产品信息： productId={}",product);
            return null;
        }
        ProductDetailVo detailVo = new ProductDetailVo();
        detailVo.setCatName(product.getCatName());
        detailVo.setProductName(product.getProductName());
        detailVo.setProductId(productId);
        detailVo.setPrice(product.getPrice());
        detailVo.setSkuId(product.getSkuId());
        detailVo.setStockNum(product.getStockNum());

        List<CommentVo> commentVoList =commentService.getProductComments(productId);
        if(CollectionUtils.isNotEmpty(commentVoList)){
            List<DetailCommentVo> detailCommentVos = new ArrayList<>(commentVoList.size());
            commentVoList.stream().forEach(c -> {
                DetailCommentVo dVo = new DetailCommentVo();
                BeanUtils.copyProperties(c,dVo);
                detailCommentVos.add(dVo);
            });
            detailVo.setCommentVoList(detailCommentVos);
        }

        return detailVo;
    }

    @Override
    public Long getProductOrderNumById(Long productId) {
        Product product = productService.getProductById(productId);
        if(product ==null){
            log.warn("无法查询到产品信息： productId={}",product);
            return null;
        }
        List<OrderItemVo> orderItemVos = this.orderService.getRecentOrder(productId);
        return orderItemVos !=null? new Long(orderItemVos.size()):0;
    }
}
