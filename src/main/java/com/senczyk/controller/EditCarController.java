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
public class EditCarController {

	@Autowired
	private DayRepository dayRepo;
	
	@GetMapping("/editCar")
	public String editCarInfoq() {
		return "editCar";
	}
	
	@GetMapping("/editCar/{id}")
	public String editCar1(@PathVariable int id) {
		Day day = new Day();
		day = dayRepo.getOne(id);

		return "Car: "+day.getNameOfVehicle();
	}
	@PostMapping("/editCar")
	public ModelAndView editCar(Day day) {
		ModelAndView mav = new ModelAndView();
		day.setTypeOfVehicle("CAR");
		dayRepo.saveAndFlush(day);
		
		mav.setViewName("editCarComplete");
		mav.addObject(day);
		return mav;
	}
}
