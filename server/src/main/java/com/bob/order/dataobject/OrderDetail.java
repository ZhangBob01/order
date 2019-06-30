package com.bob.order.dataobject;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-15 14:32
 * @Description:
 */
@Data
public class OrderDetail {

    /** 订单详情id. */
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品图片. */
    private String productIcon;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;
}
