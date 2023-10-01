package com.dksoft.org.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dksoft.org.entity.Manufacturer;
import com.dksoft.org.exception.ManufacturerNotFoundException;
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
	public Manufacturer findManufacturerById(@PathVariable("id") int id) throws ManufacturerNotFoundException {

		Manufacturer receivedManufacture = manufacturerService.findManufacturerById(id);

		if (receivedManufacture == null) {
			throw new ManufacturerNotFoundException(" Dear User Manufacturer Not Found With Id: " + id);
		}

		return receivedManufacture;
	}

	@GetMapping("/allRecords")
	public ResponseEntity<List<Manufacturer>> findALLManufacturer() {
		List<Manufacturer> findAllManufacturered = manufacturerService.findAllManufacturer();
		findAllManufacturered.forEach(m -> {
			System.out.println(m);
		});
		return new ResponseEntity<List<Manufacturer>>(findAllManufacturered, HttpStatus.OK);
	}

	@PutMapping("updateManufacturer/{manfactureId}")
	public ResponseEntity<Manufacturer> updateManufacturerData(@RequestBody Manufacturer manufacturer,
			@PathVariable("manfactureId") int manufactureid) throws ManufacturerNotFoundException {
		Manufacturer receivedProductFromDB = manufacturerService.findManufacturerById(manufactureid);
		Manufacturer updatedManufacturer;
		if (receivedProductFromDB == null) {
			throw new ManufacturerNotFoundException("Manufacture Can not be updated with ID:" + manufactureid);
		} else {
			receivedProductFromDB.setCountryOfOrigin(manufacturer.getCountryOfOrigin());
			receivedProductFromDB.setManufacturerName(manufacturer.getManufacturerName());
			 updatedManufacturer = manufacturerService.updateManufacturer(receivedProductFromDB, manufactureid);
		}
		
		return new ResponseEntity<Manufacturer>(updatedManufacturer, HttpStatus.CREATED);
	}

}
