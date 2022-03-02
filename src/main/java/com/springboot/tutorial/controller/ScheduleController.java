package com.springboot.tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.tutorial.dtos.ScheduleDto;
import com.springboot.tutorial.model.Schedule;
import com.springboot.tutorial.service.ScheduleService;

import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
	private final ScheduleService service;

	public ScheduleController(ScheduleService service) {
		this.service = service;
	}

	// GET ( Get All Schedules )
	@GetMapping
	public List<Schedule> getSchedules() {
		return new ArrayList<>(service.getSchedules());
	}

	// GET ( Get Schedule by Id)
	@GetMapping(value = "{id}")
	public Schedule getSchedule(@PathVariable int id) {
		return service.getSchedule(id);
	}	

	// POST ( Add Schedule )
	@PostMapping
	public void addSchedule(@NonNull @RequestBody ScheduleDto scheduleDto) {
		service.addSchedule(scheduleDto);
	}

	// PUT ( Update Schedule )
	@PutMapping
	public void updateSchedule(@RequestBody ScheduleDto scheduleDto) {
		service.updateSchedule(scheduleDto);
	}
	
	// DELETE ( Delete Schedule )
	@DeleteMapping(value = "{id}")
	public void deleteSchedule(@PathVariable int id) {
		service.deleteSchedule(id);
	}

}