package com.bob.order.converter;

import com.bob.order.dataobject.OrderDetail;
import com.bob.order.dto.OrderDTO;
import com.bob.order.enums.ResultEnum;
import com.bob.order.exception.OrderException;
import com.bob.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-18 16:27
 * @Description:
 */
@Slf4j
public class ConverterUtils {

    public static OrderDTO orderForm2orderDTO(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());

        Gson gson = new Gson();

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (OrderException e) {
            log.error("【Json转换】错误，string={}",orderForm.getItems());

            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
