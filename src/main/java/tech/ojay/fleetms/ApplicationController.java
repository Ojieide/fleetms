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
}
