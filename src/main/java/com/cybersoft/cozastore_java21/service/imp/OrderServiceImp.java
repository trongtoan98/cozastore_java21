package com.cybersoft.cozastore_java21.service.imp;

import com.cybersoft.cozastore_java21.payload.request.OrderRequest;
import com.cybersoft.cozastore_java21.payload.response.OrderDetailResponse;
import com.cybersoft.cozastore_java21.payload.response.OrderResponse;
import com.cybersoft.cozastore_java21.payload.response.ProductResponse;

import java.util.List;

public interface OrderServiceImp {
    boolean addOrder(OrderRequest oderRequest);
    List<OrderResponse> getOrderByUserId(int id);
    List<OrderDetailResponse> getOrderDetailByOrderId(int id);
}
