package com.senczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;

@Controller
public class BorrowController {
	
	@Autowired
	private DayRepository dayRepo;
	
	@GetMapping("/borrow")
	public String borrowInfo() {
		return "borrow";
	}
	@PostMapping("/borrow")
	public ModelAndView borrowVehicle(Day BorrowDto) {
		ModelAndView mav = new ModelAndView();
		Day temp = new Day();
		temp = dayRepo.getOne(BorrowDto.getId());
		
		temp.setRentDate(BorrowDto.getRentDate());
		temp.setUser(BorrowDto.getUser());
		dayRepo.saveAndFlush(temp);
		mav.setViewName("Done");
		mav.addObject(temp);
		return mav;
	}
}
