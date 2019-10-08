package com.senczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.senczyk.entity.DayRepository;

@Controller
public class DeleteController {

	@Autowired
	private DayRepository dayRepo;
	
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
}
