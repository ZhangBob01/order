package com.bob.order.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-29 22:27
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MqReceiverTest{

    @Autowired
    private AmqpTemplate template;

    @Test
    public void sendMessage(){
        template.convertAndSend("myQeue","now:"+new Date());
    }
}
