package com.bob.order.service;

import com.bob.order.dto.OrderDTO;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-16 09:52
 * @Description:
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
