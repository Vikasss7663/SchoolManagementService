package com.springboot.tutorial.uiController;

import com.springboot.tutorial.dtos.LocationDto;
import com.springboot.tutorial.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/location")
@RequiredArgsConstructor
public class LocationUiController {

	private final LocationService service;

	// GET ( Get All Locations )
	@GetMapping
	public String getLocations(Model model) {
		List<LocationDto> locations = service.getLocations();
		model.addAttribute("locations", locations);
		return "location/location-list";
	}

	// GET ( Get Location by ID)
	@GetMapping(value = "{id}")
	public LocationDto getLocation(@PathVariable int id) {
		return service.getLocation(id);
	}

	// POST ( Add Location )
	@PostMapping
	public String addCourse(@ModelAttribute("location") LocationDto locationDto, Model model) {
		service.addLocation(locationDto);
		return getLocations(model);
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

	// Form Add Location
	@GetMapping(value = "add")
	public String addLocationForm(Model model) {
		model.addAttribute("location", new LocationDto());
		return "location/location-add";
	}

	// Form Update Location
	@GetMapping(value = "update/{id}")
	public String updateLocationForm(Model model, @PathVariable int id) {
		LocationDto location = service.getLocation(id);
		model.addAttribute("location", location);
		return "location/location-add";
	}

	// Form Delete Location
	@PostMapping(value = "delete/{id}")
	public String deleteLocationForm(Model model, @PathVariable int id) {
		service.deleteLocation(id);
		return getLocations(model);
	}

}