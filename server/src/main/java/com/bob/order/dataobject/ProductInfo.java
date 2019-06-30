package com.bob.order.dataobject;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-12 10:49
 * @Description:
 */
@Data
public class ProductInfo {

    private String productId;

    /** 商品名称. */
    private String productName;
    /** 单价. */
    private BigDecimal productPrice;
    /** 库存. */
    private Integer productStock;
    /** 描述. */
    private String productDescription;
    /** 小图. */
    private String productIcon;
    /** 类目编号. */
    private Integer categoryType;
    /** 状态，0正常1下架. */
    private  Integer productStatus;
    /** 创建时间. */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;
}
