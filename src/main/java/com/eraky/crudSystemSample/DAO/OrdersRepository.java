package com.eraky.crudSystemSample.DAO;

import com.eraky.crudSystemSample.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
