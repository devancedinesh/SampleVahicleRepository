package com.dksoft.org.service;

import java.util.List;

import com.dksoft.org.entity.Manufacturer;
import com.dksoft.org.exception.ManufacturerNotFoundException;

public interface ManufacturerService {

	public Manufacturer saveManufacturer(Manufacturer manufacturer);

	public Manufacturer findManufacturerById(int id);

	public List<Manufacturer> findAllManufacturer();
	public Manufacturer updateManufacturer(Manufacturer manufacturer,int manufactureId) throws ManufacturerNotFoundException ;

}
