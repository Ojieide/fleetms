package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	//Display the user page
	@GetMapping("/users")
	public String fetchUsers() {
		return "user";
	}
}
