package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.OrderDetailEntity;
import com.cybersoft.cozastore_java21.entity.ids.OrderDetailIds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailIds> {
}
