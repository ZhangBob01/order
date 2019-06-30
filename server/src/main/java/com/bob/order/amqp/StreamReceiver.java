package com.bob.order.amqp;

import com.bob.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-30 10:25
 * @Description:
 */
@Slf4j
@Component
@EnableBinding(value = {StreamClient.class})
public class StreamReceiver {


    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.RINPUT)
    public String receive(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return "received.";
    }

    @StreamListener(StreamClient.RINPUT)
    public void rreceiver(String message){
        log.info("StreamReceiver2: {}", message);
    }
}
