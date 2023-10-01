package com.dksoft.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dksoft.org.entity.ManufacturerYear;
import com.dksoft.org.entity.Product;
import com.dksoft.org.repository.ManufacturerYearRepository;
import com.dksoft.org.repository.ProductRepository;
import com.dksoft.org.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ManufacturerYearRepository repository;

	@Override
	public Product createProudct(Product product) {
		ManufacturerYear manYear = product.getManYear();
		ManufacturerYear saved = repository.save(manYear);
		product.setManYear(saved);

		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public ManufacturerYear saveManufactureYear(ManufacturerYear year) {
		ManufacturerYear saved = repository.save(year);
		return saved;
	}

	@Override
	public Product findProductById(int id) {
		Product receivedproduct = productRepository.findById(id).get();
		return receivedproduct;
	}

}
