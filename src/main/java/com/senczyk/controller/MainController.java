package com.senczyk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;

@Controller
public class MainController {
	
	@Autowired
	private DayRepository dayRepo;
	
	@RequestMapping("/")
	public String setStartPage() {
		return "startPageSelectDate";
	}
	@GetMapping("/details")
	public String setDetails() {
		return "startPageSelectDate";
	}

	@PostMapping("/details")
	public ModelAndView getDetailVehicle(String date) {
				
		List<Day> dayList = new ArrayList<>(), tempList = new ArrayList<>();
		dayList = dayRepo.findAll();
		tempList.addAll(dayList);
		
		if( !dayList.isEmpty() )
		for (Day day : dayList) {
			// jeżeli ktorys dzien nie pasuje, usun z listy dzien
			
			if( !day.getDate().contentEquals(date) ) {
				tempList.remove(day);
			}
		}
		ModelAndView mav = new ModelAndView();
		
		if( tempList.isEmpty() ) {
			mav.setViewName("noResultsFound");
		}else {
			mav.setViewName("details");
			mav.addObject(tempList.get(0));
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
	@GetMapping("/editCar")
	public String editCarInfo() {
		return "editCar";
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
	@GetMapping("/delete")
	public String delete() {
		
		return "delete";
	}
	@PostMapping("/delete")
	public String setIdToDelete(int id) {
		return "redirect:/delete/"+id;
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		dayRepo.deleteById(id);
		return "Done";
	}
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
