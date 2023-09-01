package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	//Display the contact page
	@GetMapping("/contacts")
	public String fetchContacts() {
		return "contact";
	}
}
