package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Location;
import com.example.demo.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {
    
    // Dependency Injection - Singleton
	@Autowired
	private LocationService service;
    
	// GET ( Get All Locations )
	@RequestMapping(method = RequestMethod.GET)
	public List<Location> getLocations() {
		return new ArrayList<Location>(service.getLocations());
	}

	// GET ( Get Location by Id)
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Location getLocation(@PathVariable int id) {
		return service.getLocation(id);
	}	

	// POST ( Add Location )
	@RequestMapping(method = RequestMethod.POST)
	public void addLocation(@RequestBody Location location) {
		service.addLocation(location);
	}

	// PUT ( Update Location )
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public void updateLocation(@RequestBody Location location,
							@PathVariable int id) {
		service.updateLocation(id, location);
	}
	
	// DELETE ( Delete Location )
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteLocation(@PathVariable int id) {
		service.deleteLocation(id);
	}

}
