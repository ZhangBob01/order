package com.bob.order.dto;

import lombok.Data;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-19 10:01
 * @Description:购物车传输对象
 */
@Data
public class CartDTO {
    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(){

    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
