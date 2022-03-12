package com.springboot.tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.tutorial.dtos.ScheduleDto;
import com.springboot.tutorial.dtos.ScheduleDto;
import com.springboot.tutorial.dtos.ScheduleDto;
import com.springboot.tutorial.dtos.ScheduleDto;
import com.springboot.tutorial.model.Schedule;
import com.springboot.tutorial.service.ScheduleService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    
	private final ScheduleService service;

	// GET ( Get All Schedules )
	@GetMapping
	public String getSchedules(Model model) {
		List<ScheduleDto> schedules = service.getSchedules();
		model.addAttribute("schedule", new ScheduleDto());
		model.addAttribute("schedules", schedules);
		return "schedule/schedule-list";
	}

	// GET ( Get Schedule by Id)
	@GetMapping(value = "{id}")
	public ScheduleDto getSchedule(@PathVariable int id) {
		return service.getSchedule(id);
	}

	// POST ( Add Schedule )
	@PostMapping
	public String addCourse(@ModelAttribute("schedule") ScheduleDto scheduleDto, Model model) {
		service.addSchedule(scheduleDto);
		return getSchedules(model);
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

	// Form Add Schedule
	@GetMapping(value = "add")
	public String addScheduleForm(Model model) {
		model.addAttribute("schedule", new ScheduleDto());
		return "schedule/schedule-add";
	}

	// Form Update Schedule
	@GetMapping(value = "update/{id}")
	public String updateScheduleForm(Model model, @PathVariable int id) {
		ScheduleDto schedule = service.getSchedule(id);
		model.addAttribute("schedule", schedule);
		return "schedule/schedule-add";
	}

	// Form Delete Schedule
	@PostMapping(value = "delete/{id}")
	public String deleteScheduleForm(Model model, @PathVariable int id) {
		service.deleteSchedule(id);
		return getSchedules(model);
	}
	
}