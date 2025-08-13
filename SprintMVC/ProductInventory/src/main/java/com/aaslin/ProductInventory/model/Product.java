package com.aaslin.ProductInventory.model;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component 
public class Product {
	
	@NotNull(message="Student id cannot be null")
	private int productId;
	@NotNull(message="Student name cannot be null")
	private String name;
	@NotNull(message="Student age cannot be null")
	@Positive(message="Price should be positive")
	private double price;
	
	public Product() {}
	
	public Product(int productId, String name, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
}
