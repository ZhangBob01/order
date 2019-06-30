package com.bob.order.VO;

import lombok.Data;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-24 14:38
 * @Description:
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;
}
