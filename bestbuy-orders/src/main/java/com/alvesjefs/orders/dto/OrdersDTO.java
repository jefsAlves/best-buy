package com.alvesjefs.orders.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.orders.domain.Orders;
import com.alvesjefs.orders.domain.enums.OrderStatus;

public class OrdersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer numberOrder;
	private Instant date;
	private OrderStatus orderStatus;

	private Set<ProductsDTO> products = new HashSet<>();

	public OrdersDTO() {
	}

	public OrdersDTO(Long id, Integer numberOrder, Instant date, OrderStatus orderStatus) {
		this.id = id;
		this.numberOrder = numberOrder;
		this.date = date;
		this.orderStatus = orderStatus;
	}

	public OrdersDTO(Orders orders) {
		id = orders.getId();
		numberOrder = orders.getNumberOrder();
		date = orders.getDate();
		orderStatus = orders.getOrdersStatus();
		products = orders.getProducts().stream().map(x -> new ProductsDTO(x)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(Integer numberOrder) {
		this.numberOrder = numberOrder;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set<ProductsDTO> getProducts() {
		return products;
	}
}
