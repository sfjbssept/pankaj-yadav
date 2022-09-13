package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repo.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	IProductRepository productRepository;
	
	@Override
	public Integer addProduct(Product product) {
		Product addProduct = productRepository.save(product);
		return addProduct.getId();
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public Product updateProduct(Product product, Integer id) {
		//First check if that product with that id present or not
		Product existingProd = productRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Product", "id", id));
		existingProd.setProductName(product.getProductName());
		existingProd.setProductBrand(product.getProductBrand());
		existingProd.setProductCategory(product.getProductCategory());
		existingProd.setProductPrice(product.getProductPrice());
		productRepository.save(existingProd);
		return existingProd;
	}

	@Override
	public void deleteProduct(Integer id) {
//		Product exisitingProduct = productRepository.findById(id).orElseThrow(
//				()-> new ResourceNotFoundException("Product", "id", id));
//		productRepository.delete(exisitingProduct);
		productRepository.deleteById(id);
	}

}
