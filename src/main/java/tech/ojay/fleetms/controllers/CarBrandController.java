package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarBrandController {
	//Display the car brand page
	@GetMapping("/carbrands")
	public String fetchCarBrands() {
		return "carbrand";
	}
}
