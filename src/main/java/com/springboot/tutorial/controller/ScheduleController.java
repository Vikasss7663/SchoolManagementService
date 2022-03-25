package com.springboot.tutorial.controller;

import com.springboot.tutorial.dtos.ScheduleDto;
import com.springboot.tutorial.service.ScheduleService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springboot.tutorial.constants.ApplicationConstants.CROSS_ORIGIN_URL;

@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    
	private final ScheduleService service;

	// GET ( Get All Schedules )
	@GetMapping
	public List<ScheduleDto> getSchedules() {
		return service.getSchedules();
	}

	// GET ( Get Schedule by Id)
	@GetMapping(value = "{id}")
	public ScheduleDto getSchedule(@PathVariable int id) {
		return service.getSchedule(id);
	}

	// POST ( Add Schedule )
	@PostMapping
	public void addCourse(@NonNull @RequestBody ScheduleDto scheduleDto) {
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