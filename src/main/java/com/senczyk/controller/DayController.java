package com.senczyk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;
import com.senczyk.enums.TypeOfVehicle;
import com.senczyk.service.DayService;

import javassist.NotFoundException;

@RestController
public class DayController {
	
	@Autowired
	private DayService dayService;
	
	@RequestMapping("/")
	public String setStartPage() {
		return "Test for connection";
	}
	
	@GetMapping("/details/{id}")
	public Day showCar(@PathVariable int id) {
		return dayService.readDay(id);
	}
	
	@PostMapping("/addBike")
	public void addBike(@RequestBody Day day) {
		day.setTypeOfVehicle(TypeOfVehicle.BIKE);
		dayService.addDay(day);
	}
	
	@PostMapping("/addCar")
	public void addCar(@RequestBody Day day) {
		day.setTypeOfVehicle(TypeOfVehicle.CAR);
		dayService.addDay(day);
	}
	
	@PutMapping("/editCar/{id}")
	public String editCar(@PathVariable int id, @RequestBody Day day) {
		try {
			dayService.validateIfExist(id);			
		} catch(NotFoundException e) {
			return e.getMessage();
		}
		dayService.editDay(day, id);
		return "Done!";
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteDay(@PathVariable int id) {
		dayService.deleteCar(id);
	}
	
	@GetMapping("/showAll")
	public List<Day> showAll(){
		return dayService.readAllDay();
	}

}
