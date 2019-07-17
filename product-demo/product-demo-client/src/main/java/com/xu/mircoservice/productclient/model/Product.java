package com.xu.mircoservice.productclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@NoArgsConstructor
@Data
public class Product implements Serializable {
    private Long productId;
    private String skuId;
    private String productName;
    private BigDecimal price;
    private String catName;
    private Long stockNum;
    private String extInfo;

}
