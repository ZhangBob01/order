package com.bob.order.dao;

import com.bob.order.dataobject.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-17 09:43
 * @Description:
 */
public interface OrderDetailDAO {

    /**
     * 保存订单详情
     * @param orderDetail
     * @return
     */
    int saveByObject(OrderDetail orderDetail);

    /**
     * 保存订单详情
     * @param detailMap
     * @return
     */
    int saveByMap(Map detailMap);

    /**
     * 更新订单详情
     * @param orderDetail
     * @return
     */
    int updateByObject(OrderDetail orderDetail);

    /**
     * 删除订单详情
     * @param datailId
     * @return
     */
    int deleteById(String datailId);

    /**
     * 查询所有订单详情
     * @return
     */
    List<OrderDetail> findAll();

    /**
     * 根据OrderId查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
