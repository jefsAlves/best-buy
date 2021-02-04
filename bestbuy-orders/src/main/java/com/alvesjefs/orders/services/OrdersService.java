package com.alvesjefs.orders.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.orders.domain.Orders;
import com.alvesjefs.orders.domain.enums.OrderStatus;
import com.alvesjefs.orders.dto.OrdersDTO;
import com.alvesjefs.orders.repository.OrdersRepository;
import com.alvesjefs.orders.services.exceptions.NumberNotFoundException;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Transactional(readOnly = true)
	public OrdersDTO findByNumber(Integer number) {
		Orders findNumber = ordersRepository.findByNumberOrder(number);
		if (findNumber == null) {
			throw new NumberNotFoundException("Number not found!");
		}

		return new OrdersDTO(findNumber);
	}

	@Transactional(readOnly = true)
	public List<OrdersDTO> findByStatus(OrderStatus orderStatus) {
		List<Orders> findStatus = ordersRepository.findByOrdersStatus(orderStatus);
		return findStatus.stream().map(x -> new OrdersDTO(x)).collect(Collectors.toList());
	}
}
