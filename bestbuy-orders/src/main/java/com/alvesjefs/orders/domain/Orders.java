package com.alvesjefs.orders.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.alvesjefs.orders.domain.enums.OrderStatus;

@Entity
@Table(name = "TB_ORDERS")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numberOrder;
	private Instant date;
	private OrderStatus ordersStatus;

	@ManyToMany
	@JoinTable(
	name = "TB_ORDERS_PRODUCTS",
	joinColumns = @JoinColumn (name = "ORDER_ID"),
	inverseJoinColumns = @JoinColumn (name = "PRODUCT_ID"))
	private Set<Products> products = new HashSet<>();

	public Orders() {
	}

	public Orders(Long id, Integer numberOrder, Instant date, OrderStatus ordersStatus) {
		this.id = id;
		this.date = date;
		this.numberOrder = numberOrder;
		this.ordersStatus = ordersStatus;
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

	public OrderStatus getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(OrderStatus ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [id=");
		builder.append(id);
		builder.append(", numberOrder=");
		builder.append(numberOrder);
		builder.append(", date=");
		builder.append(date);
		builder.append(", ordersStatus=");
		builder.append(ordersStatus);
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}

}
