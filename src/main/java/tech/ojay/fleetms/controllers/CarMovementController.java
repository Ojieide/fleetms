package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarMovementController {
	//Display the car movement page
	@GetMapping("/carmovements")
	public String fetchCarMovements() {
		return "carmovement";
	}
}
