package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {
	//Display the location page
	@GetMapping("/locations")
	public String fetchLocations() {
		return "location";
	}
}
