package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@PostMapping("/addProduct")
	Integer addProduct(@RequestBody Product product) {
		Integer id = productService.addProduct(product);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("/getProducts")
	List<Product> getProducts(){
		List<Product> productLists = productService.getAllProducts();
		return productLists;
	}
	
	@GetMapping("/product/{id}")
	Optional<Product> getProduct(@PathVariable Integer id){
		Optional<Product> product = productService.getProduct(id);
		return product;
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id) {
		System.out.println(id);
		ResponseEntity<Product> entity = new ResponseEntity<Product>(HttpStatus.OK);
		try {
			productService.deleteProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return entity;
	}

}
