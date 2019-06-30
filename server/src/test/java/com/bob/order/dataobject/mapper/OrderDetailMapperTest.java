package com.bob.order.dataobject.mapper;

import com.bob.order.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: toudaizhi
 * @Date: 2019-06-04 18:13
 * @Description:
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class OrderDetailMapperTest {

    @Autowired
    private OrderDetailMapper mapper;

    @Test
    public void findByOrderId(){
        List<OrderDetail> orderDetailList = mapper.findByOrderId("O1558502754925767244");
        for (OrderDetail orderDetail:orderDetailList){
            System.out.println(orderDetail);
        }
    }
}