package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
	//Display the client page
	@GetMapping("/clients")
	public String fetchClients() {
		return "client";
	}
}
