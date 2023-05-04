package com.dksoft.org.service;

import java.util.List;

import com.dksoft.org.entity.Manufacturer;

public interface ManufacturerService {

	public Manufacturer saveManufacturer(Manufacturer manufacturer); 
	public Manufacturer findManufacturerById(int id); 
	public List<Manufacturer> findAllManufacturer(); 
	
}
