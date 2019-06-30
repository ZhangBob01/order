package com.bob.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-18 10:37
 * @Description:
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 手机号必填
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 收货地址
     */
    @NotEmpty(message = "收货地址必填")
    private String address;

    /**
     * openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车信息
     */
    @NotEmpty(message = "购物车信息必填")
    private String items;

}
