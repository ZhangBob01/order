package com.bob.order.dao;

import com.bob.order.dataobject.OrderMaster;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-16 14:04
 * @Description:
 */
public interface OrderMasterDAO {

    /**
     * 保存订单
     * @param OrderMaster
     * @return
     */
    int save(OrderMaster OrderMaster);

    /**
     * 根据id查询订单信息
     * @param orderId
     * @return
     */
    OrderMaster findByOrderId(String orderId);

    /**
     * 更新订单
     * @param orderMaster
     * @return
     */
    int update(OrderMaster orderMaster);
}
