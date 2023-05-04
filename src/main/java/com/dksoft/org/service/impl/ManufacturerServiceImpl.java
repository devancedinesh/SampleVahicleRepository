package com.dksoft.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dksoft.org.entity.Manufacturer;
import com.dksoft.org.repository.ManufacturerRepository;
import com.dksoft.org.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Override
	public Manufacturer saveManufacturer(Manufacturer manufacturer) {
		Manufacturer savedManufacturere = manufacturerRepository.save(manufacturer);
		return savedManufacturere;
	}

}
