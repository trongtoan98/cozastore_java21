package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.CountryEntity;
import com.cybersoft.cozastore_java21.entity.OrderDetailEntity;
import com.cybersoft.cozastore_java21.entity.OrderEntity;
import com.cybersoft.cozastore_java21.entity.ids.OrderDetailIds;
import com.cybersoft.cozastore_java21.payload.request.OrderProductRequest;
import com.cybersoft.cozastore_java21.payload.request.OrderRequest;
import com.cybersoft.cozastore_java21.repository.OrderDetailRepository;
import com.cybersoft.cozastore_java21.repository.OrderRepository;
import com.cybersoft.cozastore_java21.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService implements OrderServiceImp {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public boolean addOrder(OrderRequest orderRequest){
        CountryEntity country = new CountryEntity();
        country.setId(orderRequest.getCountry_id());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCountry(country);
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


}
