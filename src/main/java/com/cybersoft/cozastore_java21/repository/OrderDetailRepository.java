package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.OrderDetailEntity;
import com.cybersoft.cozastore_java21.entity.ProductEntity;
import com.cybersoft.cozastore_java21.entity.ids.OrderDetailIds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailIds> {
    List<OrderDetailEntity> findByOrderId(int orderId);
}
