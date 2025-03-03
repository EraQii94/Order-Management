package com.eraky.crudSystemSample.Repository;

import com.eraky.crudSystemSample.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
