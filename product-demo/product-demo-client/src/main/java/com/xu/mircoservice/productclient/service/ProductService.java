package com.xu.mircoservice.productclient.service;

import com.xu.mircoservice.productclient.model.Product;

public interface ProductService {
    public Product getProductById(Long productId);

    public Product getProductByName(String name);

}
