package org.formation.service;

import java.util.List;

import org.formation.model.Product;
import org.formation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) throws ProductNotFoundException {
		Product p = productRepository.findById(product.getId()).orElseThrow(() -> new ProductNotFoundException(""+product.getId()));
		return productRepository.save(p);
	}
	
	public List<Product> findProduct(String q) {
		return productRepository.findByNameContainingIgnoreCase(q);
	}
	
}
