package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarMaintenanceController {
	//Display the car maintenance page
	@GetMapping("/carmaintenance")
	public String fetchCarMaintenance() {
		return "carmaintenance";
	}
}
