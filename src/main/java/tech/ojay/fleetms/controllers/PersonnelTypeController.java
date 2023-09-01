package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonnelTypeController {
	//Display the personnel type page
	@GetMapping("/personneltypes")
	public String fetchPersonnelTypes() {
		return "personneltype";
	}
}
