package com.dksoft.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dksoft.org.entity.Manufacturer;
import com.dksoft.org.entity.Product;
import com.dksoft.org.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {
	@Autowired
	private ProductServiceImpl service;

	@PostMapping("/saveProducts")
	public ResponseEntity<Product> saveManufacturerData(@RequestBody Product product) {
		Product savedProduct = service.createProudct(product);

		System.out.println("Product  has been saved Successfully");

		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable ("id") int id) {
	Product recievedProduct = service.findProductById(id);
	return recievedProduct;
		
	}

}
