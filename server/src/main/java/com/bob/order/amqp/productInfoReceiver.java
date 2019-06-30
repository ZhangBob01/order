package com.bob.order.amqp;

import com.bob.order.utils.JsonUtil;
import com.bob.product.common.ProductInfoOutput;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-06-01 18:50
 * @Description:
 */
@Component
@Slf4j
public class productInfoReceiver {
    @Autowired
    private StringRedisTemplate template;

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.jsonFormObject(message, new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到的数据：{}", "productInfo",productInfoOutputList );

        //存入redis
        for (ProductInfoOutput productInfoOutput:productInfoOutputList){

            template.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
            log.info(template.opsForValue().get(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId())));
        }
    }
}
