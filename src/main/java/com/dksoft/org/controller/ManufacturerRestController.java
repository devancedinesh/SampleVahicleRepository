package com.dksoft.org.controller;

import java.util.List;

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
import com.dksoft.org.service.ManufacturerService;

@RestController
@RequestMapping("/api/v1/manufacturer")
public class ManufacturerRestController {

	@Autowired
	private ManufacturerService manufacturerService;

	@PostMapping("saveManufacturer")
	public ResponseEntity<Manufacturer> saveManufacturerData(@RequestBody Manufacturer manufacturer) {
		Manufacturer savedManufacturer = manufacturerService.saveManufacturer(manufacturer);

		System.out.println("This Record has been saved Successfully");

		return new ResponseEntity<Manufacturer>(savedManufacturer, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Manufacturer findManufacturerById(@PathVariable("id") int id) {
		Manufacturer receivedManufacture = manufacturerService.findManufacturerById(id);

		return receivedManufacture;
	}

	@GetMapping("/allRecords")
	public List<Manufacturer> findALLManufacturer(){
		List<Manufacturer> findAllManufacturered = manufacturerService.findAllManufacturer();
		findAllManufacturered.forEach(m->{
			System.out.println(m);
		});
		return findAllManufacturered;
	}
	
}
