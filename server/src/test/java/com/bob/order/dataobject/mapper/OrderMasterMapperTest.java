package com.bob.order.dataobject.mapper;

import com.bob.order.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-22 12:28
 * @Description:
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class OrderMasterMapperTest {

    @Autowired
    private OrderMasterMapper mapper;

    @Test
    public void findById(){
        OrderMaster orderMaster = mapper.findById("O1555464571806678060");
        System.out.println(orderMaster);
    }

}