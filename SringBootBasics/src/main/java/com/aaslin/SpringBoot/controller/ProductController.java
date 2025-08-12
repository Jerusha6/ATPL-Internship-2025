package com.aaslin.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.SpringBoot.service.ProductService;
import com.aaslin.SpringBoot.model.Product;

@RestController 
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public List<Product> show(){
		return service.getProducts();
	}
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId) {
		return service.getProduct(productId);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		 service.addProduct(product);
	}
	
	@PutMapping("/products/{productId}")
	public void updateProduct(@PathVariable int productId, @RequestBody Product product) {
		service.updateProduct(productId, product);
	}
	
	//	To delete all the products
	@DeleteMapping("/products")
	public void deleteProducts() {
		service.deleteProducts();
	}
	
	// To delete by Id
	@DeleteMapping("/products/{productId}")
	public void deleteProductById(@PathVariable int productId) {
		service.deleteProductById(productId);
	}
	
}
