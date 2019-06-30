package com.bob.order.enums;

import lombok.Getter;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-15 18:09
 * @Description:
 */
@Getter
public enum OrderStatusEnums {
    /**
     * 订单状态
     */
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
