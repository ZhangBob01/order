package com.bob.order.dataobject.mapper;

import com.bob.order.dataobject.OrderDetail;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-17 09:43
 * @Description:
 */
public interface OrderDetailMapper {

    int saveByObject(OrderDetail orderDetail);

    int deteleById(String orderDetailId);

    int updateByObject(OrderDetail orderDetail);

    List<OrderDetail> findAll();

    List<OrderDetail> findByOrderId(String orderId);
}
