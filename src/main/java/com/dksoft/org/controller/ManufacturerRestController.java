package com.dksoft.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private ManufacturerService manufacturerService ;

	@PostMapping("saveManufacturer")
	public ResponseEntity<Manufacturer> saveManufacturerData(@RequestBody Manufacturer manufacturer){
	Manufacturer savedManufacturer = manufacturerService.saveManufacturer(manufacturer);
		
		System.out.println("This Record has been saved Successfully");
		
		return new ResponseEntity<Manufacturer>(savedManufacturer,HttpStatus.CREATED);
	}
}
