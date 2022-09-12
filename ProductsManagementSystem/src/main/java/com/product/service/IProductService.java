package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface IProductService {
	
	Integer addProduct(Product product);
	public List<Product> getAllProducts();

}
