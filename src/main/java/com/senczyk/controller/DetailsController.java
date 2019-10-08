package com.senczyk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;

@Controller
public class DetailsController {

	@Autowired
	private DayRepository dayRepo;
	
	@PostMapping("/details")
	public ModelAndView getDetailVehicle(String date) {
		List<Day> dayList = new ArrayList<>(), tempList = new ArrayList<>();
		dayList = dayRepo.findAll();
		
		if( !dayList.isEmpty() )
		for (Day day : dayList) {
			if( day.getDate().contentEquals(date) ) {
				tempList.add(day);
			}
		}
		ModelAndView mav = new ModelAndView();
		if( tempList.isEmpty() ) {
			mav.setViewName("noResultsFound");
		}else {
			mav.setViewName("details");
			mav.addObject("date", date);
		}
	
		return mav;
	}
	@GetMapping("/details/{id}")
	public ModelAndView getOneVehicle(@PathVariable int id) {
		Day day = new Day();
		day = dayRepo.getOne(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("details");
		mav.addObject(day);
		return mav;
	}
}
