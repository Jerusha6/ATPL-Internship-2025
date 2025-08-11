package com.aaslin.SpringBoot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.SpringBoot.model.Product;

@Service 
public class ProductService {
	
	@Autowired 
	Product product;
	List<Product> productList = new ArrayList<>(Arrays.asList(
					new Product(1, "Refrigerator", 30000.00),
					new Product(2,"AC", 44999.00),
					new Product(3,"Crompton Fan", 12000.00)
			));
	
	// To fetch all products
	public List<Product> getProducts() {
		return productList;
	}
	
	// To fetch single product by ID
	public Product getProduct(int productId) {
	    return productList.stream()
	                   .filter(p -> p.getProductId() == productId)
	                   .findFirst()
	                   .orElse(null);
	}
	
	// To add product into the list
	public void addProduct(Product product) {
		productList.add(product);
	}

	// To update product 
	public void updateProduct(int productId, Product updateProduct) {
		 for(int i=0;i<productList.size();i++) {
			 if(productList.get(i).getProductId()==productId) {
				 productList.set(i, updateProduct);
				 break;
			 }
		 }
	}
	
	// To delete all products
	public void deleteProducts() {
		productList.removeAll(productList);
	}
	
	// To delete product by ID
	public void deleteProductById(int productId) {
		 for(int i=0;i<productList.size();i++) {
			 if(productList.get(i).getProductId()==productId) {
				 productList.remove(i);
				 break;
			 }
		 }
	}
}