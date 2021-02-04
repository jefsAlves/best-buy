package com.alvesjefs.products.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvesjefs.products.domain.Products;
import com.alvesjefs.products.dto.ProductsDTO;
import com.alvesjefs.products.services.ProductsService;

@RestController
@RequestMapping(value = "api/products")
public class ProductsResource {

	@Autowired
	private ProductsService productsService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> findById(@PathVariable Long id) {
		Products findId = productsService.findByEmail(id);
		return ResponseEntity.ok().body(findId);
	}

//	@GetMapping(value = "/searchName")
//	public ResponseEntity<ProductsDTO> findByName(@RequestParam String name) {
//		ProductsDTO findName = productsService.findByName(name);
//		return ResponseEntity.ok().body(findName);
//	}

	@PostMapping(value = "/insert")
	public ResponseEntity<ProductsDTO> inserProducts(@RequestBody ProductsDTO productsDTO) {
		ProductsDTO insertProducts = productsService.insertProduct(productsDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productsDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(insertProducts);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ProductsDTO> updateProducts(@PathVariable Long id, @RequestBody ProductsDTO productsDTO) {
		ProductsDTO udpate = productsService.updateProduct(id, productsDTO);
		return ResponseEntity.ok().body(udpate);
	}

	@DeleteMapping(value = "/deleted/{id}")
	public ResponseEntity<ProductsDTO> deleteProducts(@PathVariable Long id) {
		productsService.deleteProducts(id);
		return ResponseEntity.noContent().build();
	}
}
