package com.school.management.controller;

import com.school.management.dtos.LocationDto;
import com.school.management.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.management.constants.ApplicationConstants.CROSS_ORIGIN_URL;

@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    
	private final LocationService service;

	// GET ( Get All Locations )
	@GetMapping
	public List<LocationDto> getLocations() {
		return service.getLocations();
	}

	// GET ( Get Location by ID)
	@GetMapping(value = "{id}")
	public LocationDto getLocation(@PathVariable int id) {
		return service.getLocation(id);
	}	

	// POST ( Add Location )
	@PostMapping
	public void addCourse(@RequestBody LocationDto locationDto) {
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
