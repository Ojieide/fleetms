package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarModelController {
	//Display the car model page
	@GetMapping("/carmodels")
	public String fetchCarModels() {
		return "carmodel";
	}
}
