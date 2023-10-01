package com.dksoft.org.service;

import com.dksoft.org.entity.ManufacturerYear;
import com.dksoft.org.entity.Product;

public interface ProductService {
	public Product createProudct(Product product);
	public ManufacturerYear saveManufactureYear(ManufacturerYear year);
	public Product findProductById(int id);

	
	
}
