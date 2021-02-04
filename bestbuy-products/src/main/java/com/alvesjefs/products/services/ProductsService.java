package com.alvesjefs.products.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.products.domain.Products;
import com.alvesjefs.products.dto.ProductsDTO;
import com.alvesjefs.products.repository.ProductsRepository;
import com.alvesjefs.products.services.exceptions.IdNotFoundException;
import com.alvesjefs.products.services.exceptions.ProductAlreadyExistsException;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	@Transactional(readOnly = true)
	public Products findByEmail(Long id) {
		Optional<Products> findId = productsRepository.findById(id);
		return findId.orElseThrow(() -> new IdNotFoundException("Id not found!"));
	}

//	@Transactional(readOnly = true)
//	public ProductsDTO findByName(String name) {
//		Products findName = productsRepository.findByName(name);
//		if (name == null) {
//			throw new NameNotFoundException("Name not found!");
//		}
//		return new ProductsDTO(findName);
//	}

	@Transactional
	public ProductsDTO insertProduct(ProductsDTO productsDTO) {
		Products findName = productsRepository.findByName(productsDTO.getName());
		if (findName != null) {
			throw new ProductAlreadyExistsException("This product already exists!");
		}
		Products products = new Products(null, productsDTO.getName(), productsDTO.getDescription());
		products = productsRepository.save(products);
		return new ProductsDTO(products);
	}

	@Transactional
	public ProductsDTO updateProduct(Long id, ProductsDTO productsDTO) {
		Products products = productsRepository.getOne(id);
		products.setName(productsDTO.getName());
		products = productsRepository.save(products);
		return new ProductsDTO(products);
	}

	@Transactional
	public void deleteProducts(Long id) {
		try {
			productsRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new IdNotFoundException("Id not found!");
		}
	}

}
