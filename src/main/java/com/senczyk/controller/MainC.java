package com.senczyk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;

@RestController
@RequestMapping("/JSON")
public class MainC {
	
	@Autowired
	private DayRepository dayRepo;
	
	@GetMapping("/display")
	public Day getJSONDisplay() {
		return dayRepo.getOne(1);
	}
	
	@GetMapping("/")
	public List<Day> findAllAtBegining(){
		return dayRepo.findAll();
	}
	
}
