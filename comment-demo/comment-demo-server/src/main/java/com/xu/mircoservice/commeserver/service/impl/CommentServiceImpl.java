package com.xu.mircoservice.commeserver.service.impl;

import com.xu.mircoservice.commeclient.model.CommentVo;
import com.xu.mircoservice.commeclient.service.CommentService;
import com.xu.mircoservice.productclient.model.Product;
import com.xu.mircoservice.productclient.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Reference
    private ProductService productService;

    @Override
    public List<CommentVo> getUserComments(Long userId) {
        List<CommentVo> commentVos = new ArrayList<>();
        for(int i=0;i<new Random().nextInt(10);i++){
            CommentVo commentVo = new CommentVo();
            commentVo.setUserId(userId);
            commentVo.setProductId(new Random().nextLong());
            commentVo.setSubOrderId(new Random().nextLong());
            commentVo.setContent("来自用户："+commentVo.getUserId());
            commentVo.setCommentTime(new Date());
            commentVos.add(commentVo);
        }
        commentVos.stream().forEach(comment->{
           Product p= this.productService.getProductById(comment.getProductId());
           comment.setProductName(p.getProductName());
           comment.setCatName(p.getCatName());
           comment.setContent(comment.getContent()+"，来自对产品： "+p.getProductName()+" 的评价！");
        });
        return commentVos;
    }

    @Override
    public List<CommentVo> getProductComments(Long productId) {
        if(productId ==null){
            log.warn("输入参数为null ");
        }
        Product product = productService.getProductById(productId);
        if(product==null){
            log.warn("无法获取到产品，productId={}",productId);
        }
        List<CommentVo> commentVos = new ArrayList<>();
        for(int i=0;i<new Random().nextInt(10);i++){
            CommentVo commentVo = new CommentVo();
            commentVo.setUserId(new Random().nextLong());
            commentVo.setProductId(productId);
            commentVo.setCommentTime(new Date());
            commentVo.setSubOrderId(new Random().nextLong());
            commentVo.setProductName(product.getProductName());
            commentVo.setCatName(product.getCatName());
            commentVo.setContent("这个东西："+product.getProductName()+",真是太好了！，来自用户："+commentVo.getUserId());
            commentVos.add(commentVo);
        }
        return commentVos;
    }
}
