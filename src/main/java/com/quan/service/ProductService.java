package com.quan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.Repository.ProductRepository;
import com.quan.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product getProduct(int id) {
		return productRepository.findById(id).get();
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
}
