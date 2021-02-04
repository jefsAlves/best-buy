package com.alvesjefs.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.products.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

	Products findByName(String name);
}
