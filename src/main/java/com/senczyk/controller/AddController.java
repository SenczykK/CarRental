package com.senczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;

@Controller
public class AddController {

	@Autowired
	private DayRepository dayRepo;
	
	@GetMapping("/addBike/{id}")
	public String addBike(@PathVariable int id) {
		Day d = new Day();
		d.setId(id);
		d.setTypeOfVehicle("BIKE");
		dayRepo.save(d);
		return "SavedBike";
	}
	
	
	@GetMapping("/addCar")
	public String addCarInfo() {
		return "addCar";
	}
	
	@PostMapping("/addCar")
	public ModelAndView addCar( Day day) {
		ModelAndView mav = new ModelAndView();
		
		day.setTypeOfVehicle("CAR");
		//save Car to database
		dayRepo.save(day);
		mav.setViewName("newCarView");
		mav.addObject(day);
		
		return mav;
	}
}
