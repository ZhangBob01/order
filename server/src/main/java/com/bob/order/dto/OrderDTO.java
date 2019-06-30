package com.bob.order.dto;

import com.bob.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-16 09:54
 * @Description:
 */
@Data
public class OrderDTO {
    /** 订单Id. */
    private String orderId;

    /** 买家姓名. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家openid. */
    private String buyerOpenid;

    /** 订单金额. */
    private BigDecimal orderAmount;

    /** 订单状态. */
    private Integer orderStatus;

    /** 支付状态. */
    private Integer payStatus;

    /** 商品详情. */
    private List<OrderDetail> orderDetailList;
}
