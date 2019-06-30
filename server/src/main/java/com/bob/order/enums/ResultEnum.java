package com.bob.order.enums;

import lombok.Getter;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-18 11:30
 * @Description:
 */
@Getter
public enum ResultEnum {
    /**
     * 订单返回枚举
     */
    PARAM_ERROR(1001,"参数错误"),
    CART_EMPTY(1002,"购物车为空"),
    ORDER_NOT_EXIT(1003,"订单不存在"),
    ORDER_STATUS_ERROR(1004,"订单状态错误"),
    ORDER_DETAIL(1005, "订单详情不存在");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
