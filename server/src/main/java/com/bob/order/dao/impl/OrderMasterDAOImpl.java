package com.bob.order.dao.impl;

import com.bob.order.dao.OrderMasterDAO;
import com.bob.order.dataobject.OrderMaster;
import com.bob.order.dataobject.mapper.OrderMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-16 14:05
 * @Description:
 */
@Repository
public class OrderMasterDAOImpl implements OrderMasterDAO {
    @Autowired
    private OrderMasterMapper mapper;


    @Override
    public int save(OrderMaster OrderMaster) {
        return mapper.saveByObject(OrderMaster);
    }

    @Override
    public OrderMaster findByOrderId(String orderId) {
        return mapper.findById(orderId);
    }

    @Override
    public int update(OrderMaster orderMaster) {
        return mapper.update(orderMaster);
    }
}
