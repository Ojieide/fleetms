package tech.ojay.fleetms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	//Display the index page
	@GetMapping("/index")
	public String fetchIndex() {
		return "index";
	}
	
	//Display the login page
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//Display the logout page
	@GetMapping("/logout")
	public String logout() {
		return "pages-login";
	}
}
