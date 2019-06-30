package com.bob.order.service.impl;

import com.bob.order.dao.OrderDetailDAO;
import com.bob.order.dao.OrderMasterDAO;
import com.bob.order.dataobject.OrderDetail;
import com.bob.order.dataobject.OrderMaster;
import com.bob.order.dto.OrderDTO;
import com.bob.order.enums.OrderStatusEnums;
import com.bob.order.enums.PayStatusEnum;
import com.bob.order.enums.ResultEnum;
import com.bob.order.exception.OrderException;
import com.bob.order.service.OrderService;
import com.bob.order.utils.KeyUtil;
import com.bob.product.client.ProductClient;
import com.bob.product.common.DecreaseStockInput;
import com.bob.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-16 09:59
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterDAO orderMasterDAO;
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey("O");

        //查询商品信息
        List<String> idList = orderDTO.getOrderDetailList().stream().map(e->e.getProductId()).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(idList);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for (ProductInfoOutput productInfo:productInfoList){
                if (orderDetail.getProductId().equals(productInfo.getProductId())){
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    String detailId = KeyUtil.getUniqueKey("D");
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(detailId);
                    orderDetailDAO.saveByObject(orderDetail);

                }
            }

        }
        //扣库存
        List<DecreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        orderDTO.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderDTO.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderDTO.setOrderAmount(orderAmount);

        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterDAO.save(orderMaster);

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(String orderId) {
        //1. 查询订单信息
        OrderMaster orderMaster = orderMasterDAO.findByOrderId(orderId);
        //2.判断订单
        if(orderMaster == null){
            throw new OrderException(ResultEnum.ORDER_NOT_EXIT);
        }
        if(!orderMaster.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())){
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //3.修改状态为完结
        orderMaster.setOrderStatus(OrderStatusEnums.FINISHED.getCode());
        orderMasterDAO.update(orderMaster);

        //4.构建OrderDTO
        List<OrderDetail> orderDetailList = orderDetailDAO.findByOrderId(orderId);
        if(orderDetailList == null){
            throw new OrderException(ResultEnum.ORDER_DETAIL);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }


}
