package com.xu.mircoservice.orderdemo.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
public class SubOrderItemVo implements Serializable {
    private Long subOrderId;
    private Long productId;
    private Long productNum;
    private BigDecimal unitPrice;
    private Date commentTime; //评论时间
    private String productName;
    private String catName;
}
