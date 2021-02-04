package com.alvesjefs.orders.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.orders.domain.enums.OrderStatus;
import com.alvesjefs.orders.dto.OrdersDTO;
import com.alvesjefs.orders.services.OrdersService;

@RestController
@RequestMapping(value = "api/orders")
public class OrdersResource {

	@Autowired
	private OrdersService ordersService;

	@GetMapping(value = "/searchNumber/{number}")
	public ResponseEntity<OrdersDTO> findByNumber(@PathVariable Integer number) {
		OrdersDTO findNumber = ordersService.findByNumber(number);
		return ResponseEntity.ok().body(findNumber);
	}

	@GetMapping(value = "/searchStatus/{status}")
	public ResponseEntity<List<OrdersDTO>> findByStatus(@PathVariable OrderStatus status) {
		List<OrdersDTO> findStatus = ordersService.findByStatus(status);
		return ResponseEntity.ok().body(findStatus);
	}
}
