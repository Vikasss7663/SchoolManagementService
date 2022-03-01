package com.example.demo.controller;

import com.example.demo.dtos.LocationDto;
import com.example.demo.model.Location;
import com.example.demo.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    
	private final LocationService service;

	public LocationController(LocationService service) {
		this.service = service;
	}

	// GET ( Get All Locations )
	@GetMapping
	public List<Location> getLocations() {
		return new ArrayList<>(service.getLocations());
	}

	// GET ( Get Location by ID)
	@GetMapping(value = "{id}")
	public Location getLocation(@PathVariable int id) {
		return service.getLocation(id);
	}	

	// POST ( Add Location )
	@PostMapping
	public void addLocation(@RequestBody LocationDto locationDto) {
		service.addLocation(locationDto);
	}

	// PUT ( Update Location )
	@PutMapping
	public void updateLocation(@RequestBody LocationDto locationDto) {
		service.updateLocation(locationDto);
	}
	
	// DELETE ( Delete Location )
	@DeleteMapping(value = "{id}")
	public void deleteLocation(@PathVariable int id) {
		service.deleteLocation(id);
	}

}
