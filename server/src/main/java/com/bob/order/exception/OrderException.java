package com.bob.order.exception;

import com.bob.order.enums.ResultEnum;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-18 11:25
 * @Description:
 */
public class OrderException extends RuntimeException {

    private Integer code;

    private String message;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
