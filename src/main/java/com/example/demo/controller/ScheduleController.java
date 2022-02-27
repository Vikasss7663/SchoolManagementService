package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    // Dependency Injection - Singleton
	@Autowired
	private ScheduleService service;
    
	// GET ( Get All Schedules )
	@RequestMapping(method = RequestMethod.GET)
	public List<Schedule> getSchedules() {
		return new ArrayList<Schedule>(service.getSchedules());
	}

	// GET ( Get Schedule by Id)
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Schedule getSchedule(@PathVariable int id) {
		return service.getSchedule(id);
	}	

	// POST ( Add Schedule )
	@RequestMapping(method = RequestMethod.POST)
	public void addSchedule(@RequestBody Schedule schedule) {
		service.addSchedule(schedule);
	}

	// PUT ( Update Schedule )
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public void updateSchedule(@RequestBody Schedule schedule,
							@PathVariable int id) {
		service.updateSchedule(id, schedule);
	}
	
	// DELETE ( Delete Schedule )
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteSchedule(@PathVariable int id) {
		service.deleteSchedule(id);
	}

}