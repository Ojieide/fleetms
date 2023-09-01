package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StateController {
	//Display the state page
	@GetMapping("/states")
	public String fetchStates() {
		return "state";
	}
}
