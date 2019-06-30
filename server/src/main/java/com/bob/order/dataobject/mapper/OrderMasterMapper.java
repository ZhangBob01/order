package com.bob.order.dataobject.mapper;

import com.bob.order.dataobject.OrderMaster;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-15 14:42
 * @Description: 订单主表
 */
public interface OrderMasterMapper {
    /**
     * 保存订单
     * @param orderMaster
     * @return
     */
    int saveByObject(OrderMaster orderMaster);

    /**
     * 更新订单
     * @param orderMaster
     * @return
     */
    int updateByObject(OrderMaster orderMaster);

    @Update("update order_master set buyer_name = #{buyerName,jdbcType=VARCHAR}," +
            " buyer_phone = #{buyerPhone,jdbcType=VARCHAR}," +
            " buyer_address = #{buyerAddress,jdbcType=VARCHAR}, order_amount = #{orderAmount,jdbcType=DECIMAL}," +
            " order_status = #{orderStatus,jdbcType=INTEGER}, pay_status = #{payStatus,jdbcType=INTEGER}" +
            " where order_id = #{orderId,jdbcType=VARCHAR}")
    int update(OrderMaster orderMaster);

    /**
     * 根据Id查询订单信息
     * @param orderId
     * @return
     */
    @Select("select * from order_master where order_id = #{orderId}")
    @Results({
            @Result(column = "order_id",property = "orderId"),
            @Result(column = "buyer_phone",property = "buyerPhone"),
            @Result(column = "buyer_address",property = "buyerAddress"),
            @Result(column = "order_amount",property = "orderAmount"),
            @Result(column = "buyer_name",property = "buyerName"),
            @Result(column = "order_status",property = "orderStatus"),
            @Result(column = "pay_status",property = "payStatus")

    })
    OrderMaster findById(String orderId);
}
