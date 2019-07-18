package com.xu.mircoservice.detailclient.service;

import com.xu.mircoservice.detailclient.model.ProductDetailVo;

public interface ProductDetailService {
    public ProductDetailVo getProductDetailById(Long productId);
    public Long getProductOrderNumById(Long productId);
}
