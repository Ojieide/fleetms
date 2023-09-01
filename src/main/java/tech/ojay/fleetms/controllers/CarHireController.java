package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarHireController {
	//Display the car hire page
	@GetMapping("/carhires")
	public String fetchCarHires() {
		return "carhire";
	}
}
