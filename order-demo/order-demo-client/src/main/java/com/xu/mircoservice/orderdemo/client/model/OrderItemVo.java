package com.xu.mircoservice.orderdemo.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@Data
public class OrderItemVo  implements Serializable {
    private Long orderId;
    private Long userId;
    private Date orderTime;
    private Integer productNum;
    private BigDecimal totalAmount;
    private List<SubOrderItemVo> subOrderItemVoList;
}
