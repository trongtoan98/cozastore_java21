package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.*;
import com.cybersoft.cozastore_java21.entity.ids.OrderDetailIds;
import com.cybersoft.cozastore_java21.payload.request.OrderProductRequest;
import com.cybersoft.cozastore_java21.payload.request.OrderRequest;
import com.cybersoft.cozastore_java21.payload.response.OrderDetailResponse;
import com.cybersoft.cozastore_java21.payload.response.OrderResponse;
import com.cybersoft.cozastore_java21.repository.OrderDetailRepository;
import com.cybersoft.cozastore_java21.repository.OrderRepository;
import com.cybersoft.cozastore_java21.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class OrderService implements OrderServiceImp {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public boolean addOrder(OrderRequest orderRequest){

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        CountryEntity country = new CountryEntity();
        country.setId(orderRequest.getCountry_id());
        UserEntity user = new UserEntity();
        user.setId(orderRequest.getUser_id());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCountry(country);
        orderEntity.setUser(user);
        orderEntity.setDate(date);

//   khi sava thành cong thì thuoc tính của OrderEntity sẽ có giá trị
        orderRepository.save(orderEntity);

        for (OrderProductRequest data : orderRequest.getListProduct()){
            OrderDetailIds ids = new OrderDetailIds();
            ids.setOrderId(orderEntity.getId());
            ids.setProductId(data.getId());

            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setIds(ids);
            orderDetailEntity.setQuantity(data.getQuantity());
            orderDetailEntity.setPrice(data.getPrice());

            orderDetailRepository.save(orderDetailEntity);
        }


        return false;
    }

    @Override
    public List<OrderResponse> getOrderByUserId(int id) {

        List<OrderEntity> list = orderRepository.findByUserId(id);
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (OrderEntity data : list){
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(data.getId());
            orderResponse.setCountry_id(data.getCountry().getId());
            Timestamp orderTimestamp  = (Timestamp) data.getDate();
            Date orderDate = new Date(orderTimestamp.getTime());
            if(orderDate!=null){
                orderResponse.setDate((orderDate));
            }


            orderResponseList.add(orderResponse);
        }

        return orderResponseList;
    }

    @Override
    public List<OrderDetailResponse> getOrderDetailByOrderId(int id) {
        List<OrderDetailEntity> list = orderDetailRepository.findByOrderId(id);
        List<OrderDetailResponse> orderDetailResponseList = new ArrayList<>();
        ProductEntity product = new ProductEntity();
        for(OrderDetailEntity data : list){
            OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
            orderDetailResponse.setProduct_id(data.getProduct().getId());
            orderDetailResponse.setPrice(data.getPrice());
            orderDetailResponse.setQuantity(data.getQuantity());

            orderDetailResponseList.add(orderDetailResponse);
        }
        return orderDetailResponseList;
    }


}
