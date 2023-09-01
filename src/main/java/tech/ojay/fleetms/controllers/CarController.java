package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
	//Display the car page
	@GetMapping("/cars")
	public String fetchCars() {
		return "car";
	}
}
