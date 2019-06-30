package com.bob.order.controller;

import com.bob.order.amqp.StreamClient;
import com.bob.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: toudaizhi
 * @Date: 2019-05-30 10:41
 * @Description:
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/send")
    public String send(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456789");
        boolean result = streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
        return result + "";
    }
}
