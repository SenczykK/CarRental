package com.senczyk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senczyk.entity.Day;
import com.senczyk.entity.DayRepository;

import javassist.NotFoundException;

@Service
public class DayService {

	@Autowired
	private DayRepository dayRepo;
	
	//CRUD
	public Day addDay(Day day) {
		return dayRepo.save(day);
	}
	
	public Day editDay(Day day, int id) {
		day.setId(id);
		return dayRepo.save(day);
	}
	
	public Day readDay(int id) {
		return dayRepo.getOne(id);
	}
	
	public List<Day> readAllDay(){
		return dayRepo.findAll();
	}
	
	public void deleteCar(int id) {
		dayRepo.deleteById(id);
	}
	
	public boolean validateIfExist(int id) throws NotFoundException {
        if(dayRepo.existsById(id) ) {
            return true;
        }
        else {
            throw new NotFoundException("day with id: "+id+"dont exist");
        }
    }
}
