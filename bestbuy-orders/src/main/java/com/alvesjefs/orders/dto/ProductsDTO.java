package com.alvesjefs.orders.dto;

import java.io.Serializable;

import com.alvesjefs.orders.domain.Products;

public class ProductsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;

	public ProductsDTO() {
	}

	public ProductsDTO(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public ProductsDTO(Products products) {
		id = products.getId();
		name = products.getName();
		description = products.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
