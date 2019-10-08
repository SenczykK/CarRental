package com.senczyk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;

@RestController
@RequestMapping("/JSON")
public class MainRESTController {
	
	@Autowired
	private DayRepository dayRepo;
	
	
	@GetMapping("/")
	public List<Day> findAllAtBegining(){
		return dayRepo.findAll();
	}
	
	@PostMapping("/details")
	public List<Day> getDetailVehicle() {
		
		List<Day> dayList = new ArrayList<>(), tempList = new ArrayList<>();
		dayList = dayRepo.findAll();
		// Data przekazywana na sztywno z powodu wykożystania JSP i problemu z przekazaniem z skryptu do Controllera wartości date
		String date="05-10-2000";
		for( Day day: dayList){
			if(day.getDate().contentEquals(date) )
				tempList.add(day);
		}
		
		return tempList;
	}
}
