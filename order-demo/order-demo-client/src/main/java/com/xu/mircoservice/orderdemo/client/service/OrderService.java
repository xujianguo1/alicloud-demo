package com.xu.mircoservice.orderdemo.client.service;

import com.xu.mircoservice.orderdemo.client.model.OrderItemVo;

import java.util.List;

public interface OrderService {
    /**
     * 获取该用户 近期该产品的订单
     * @param userId
     * @param productId
     * @return
     */
    public List<OrderItemVo> getUserOrders(Long userId, Long productId);

    /**
     * 获取产品最近7天的订单
     * @param productId
     * @return
     */
    public List<OrderItemVo> getRecentOrder(Long productId);
}
