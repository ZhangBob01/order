package com.bob.order.dao.impl;

import com.bob.order.dao.OrderDetailDAO;
import com.bob.order.dataobject.OrderDetail;
import com.bob.order.dataobject.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-19 17:02
 * @Description:
 */
@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Autowired
    private OrderDetailMapper mapper;
    @Override
    public int saveByObject(OrderDetail orderDetail) {
        return mapper.saveByObject(orderDetail);
    }

    @Override
    public int saveByMap(Map detailMap) {
        return 0;
    }

    @Override
    public int updateByObject(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public int deleteById(String datailId) {
        return 0;
    }

    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public List<OrderDetail> findByOrderId(String orderId) {
        return mapper.findByOrderId(orderId);
    }
}
