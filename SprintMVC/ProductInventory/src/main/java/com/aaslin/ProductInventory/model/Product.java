package com.aaslin.ProductInventory.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Product {

	@Min(value = 1, message = "Product id should be greater than 0")
	private int productId;
	@NotNull(message = "Product name cannot be null")
	private String name;
	@NotNull(message = "Product price cannot be null")
	private double price;

	public Product() {
	}

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
