package com.xu.mircoservice.detailclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ProductDetailVo implements Serializable {
    private Long productId;
    private String skuId;
    private String productName;
    private String catName;
    private BigDecimal price;
    private Long stockNum;

}
