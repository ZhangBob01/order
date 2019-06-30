package com.bob.order.amqp;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-30 10:19
 * @Description:
 */

public interface StreamClient {
    String INPUT = "myInput";
    String OUTPUT = "myOutput";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    String RINPUT = "myRInput";
    String ROUTPUT = "myROutput";

    @Input(StreamClient.RINPUT)
    SubscribableChannel rinput();

    @Output(StreamClient.ROUTPUT)
    MessageChannel routput();

}
