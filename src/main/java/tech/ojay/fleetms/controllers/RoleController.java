package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
	//Display the role page
	@GetMapping("/roles")
	public String fetchRoles() {
		return "role";
	}
}
