package com.bob.order.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-29 22:23
 * @Description:
 */
@Component
@Slf4j
public class MqReceive {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue("myQeue"),
                    exchange = @Exchange("myExchange")
            )
    )
    public void process(String message){
        log.info("message:{}",message);
    }
}
