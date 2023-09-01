package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarTypeController {
	//Display the car type page
	@GetMapping("/cartypes")
	public String fetchCarTypes() {
		return "cartype";
	}
}
