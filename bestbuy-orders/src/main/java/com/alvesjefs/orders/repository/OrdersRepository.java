package com.alvesjefs.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.orders.domain.Orders;
import com.alvesjefs.orders.domain.enums.OrderStatus;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	Orders findByNumberOrder(Integer number);

	List<Orders> findByOrdersStatus(OrderStatus orderStatus);
}
