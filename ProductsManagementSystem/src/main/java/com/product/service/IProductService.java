package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entity.Product;

public interface IProductService {
	
	Integer addProduct(Product product);
	public List<Product> getAllProducts();
	Optional<Product> getProduct(Integer id);
	Product updateProduct(Product product, Integer id);
	void deleteProduct(Integer id);

}
