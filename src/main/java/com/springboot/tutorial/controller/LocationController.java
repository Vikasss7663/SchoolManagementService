package com.springboot.tutorial.controller;

import com.springboot.tutorial.dtos.LocationDto;
import com.springboot.tutorial.model.Location;
import com.springboot.tutorial.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    
	private final LocationService service;

	// GET ( Get All Locations )
	@GetMapping
	public List<LocationDto> getLocations() {
		return new ArrayList<>(service.getLocations());
	}

	// GET ( Get Location by ID)
	@GetMapping(value = "{id}")
	public LocationDto getLocation(@PathVariable int id) {
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
