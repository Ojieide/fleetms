package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarStatusController {
	//Display the car status page
	@GetMapping("/carstatus")
	public String fetchCarStatus() {
		return "carstatus";
	}
}
