package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonnelController {
	//Display the personnel page
	@GetMapping("/personnel")
	public String fetchPersonnel() {
		return "personnel";
	}
}
