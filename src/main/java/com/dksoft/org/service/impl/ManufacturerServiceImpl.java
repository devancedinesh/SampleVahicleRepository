package com.dksoft.org.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dksoft.org.entity.Manufacturer;
import com.dksoft.org.exception.ManufacturerNotFoundException;
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

	@Override
	public Manufacturer findManufacturerById(int id) {
		Optional<Manufacturer> findById = manufacturerRepository.findById(id);
		if (findById.isPresent()) {
			Manufacturer manufacturer = findById.get();
			return manufacturer;
		}
		return null;
	}

	@Override
	public List<Manufacturer> findAllManufacturer() {
		List<Manufacturer> ListOfAllManufacturer = manufacturerRepository.findAll();
		return ListOfAllManufacturer;
	}

	@Override
	public Manufacturer updateManufacturer(Manufacturer manufacturer, int manufactureId)
			throws ManufacturerNotFoundException {

		Manufacturer receivedProduct = manufacturerRepository.save(manufacturer);
		System.out.println("This method is called from service implementation class");
		return receivedProduct;
	}

}
